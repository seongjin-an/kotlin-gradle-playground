import entity.Client
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.group.ChannelGroup
import io.netty.channel.group.DefaultChannelGroup
import io.netty.handler.codec.http.*
import io.netty.handler.codec.http.websocketx.*
import io.netty.util.CharsetUtil
import io.netty.util.concurrent.GlobalEventExecutor
import service.RequestService
import java.util.concurrent.ConcurrentHashMap


class NettyWebsocketServerHandler: ChannelInboundHandlerAdapter() {

    private val HTTP_REQUEST_STRING = "request"
    private val WEBSOCKET_PATH = "/websocket"
    companion object {
        private val channelGroupMap: MutableMap<String, ChannelGroup> = HashMap()
    }
    private lateinit var client: Client
    private lateinit var handshaker: WebSocketServerHandshaker

    override fun exceptionCaught(ctx: ChannelHandlerContext?, cause: Throwable?) {
        cause?.printStackTrace()
        ctx?.close()
    }
    override fun handlerAdded(ctx: ChannelHandlerContext?) {
        val channel = ctx?.channel()
        println("${channel?.remoteAddress()} JOIN")
    }

    override fun handlerRemoved(ctx: ChannelHandlerContext?) {
//        if(channelGroupMap.containsKey(client.roomId)){
//            channelGroupMap[client.roomId]?.remove(ctx?.channel())
//        }
        println("${ctx?.channel()} disconnected")
        if(channelGroupMap.containsKey("1")){
            channelGroupMap["1"]?.remove(ctx?.channel())
        }
    }
    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        if(msg is FullHttpRequest){
            println("handle full-http-request")
            handleHttpRequest(ctx, msg)
        }else if(msg is WebSocketFrame){
            println("handle websocket-frame")
            handleWebsocketFrame(ctx, msg)
        }
    }
    override fun channelReadComplete(ctx: ChannelHandlerContext?) {
        ctx?.flush()
    }

    private fun handleHttpRequest(ctx: ChannelHandlerContext, req: FullHttpRequest) {
        //BAD REQUEST
        if(!req.decoderResult().isSuccess){
            sendHttpResponse(ctx, req, DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST))
            return
        }
        //ALLOW GET METHOD ONLY
        if(req.method() != HttpMethod.GET){
            sendHttpResponse(ctx, req, DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN))
            return
        }
        //favicon
        if("/favicon.png" == req.uri() || "/" == req.uri()){
            sendHttpResponse(ctx, req, DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND))
            return
        }

        val queryStringDecoder = QueryStringDecoder(req.uri())
        val parameters = queryStringDecoder.parameters()
        if(parameters.isEmpty() || !parameters.containsKey("id")){
            System.err.println("You did not set id")
            sendHttpResponse(ctx, req, DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND))
            return
        }

//        client = RequestService.registerClient(parameters[HTTP_REQUEST_STRING]?.get(0)!!)
        client = RequestService.registerClient(parameters["id"]?.get(0)!!)
        if(client.roomId == ""){
            System.err.println("Room Number cannot be defaulted")
            sendHttpResponse(ctx, req, DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND))
            return
        }

        //If it does not exist in the room list, it is the channel, then add a new channel to channelGroup
//        if(!channelGroupMap.containsKey(client.roomId)){
//            channelGroupMap[client.roomId] = DefaultChannelGroup(GlobalEventExecutor.INSTANCE)
//        }
        if(!channelGroupMap.containsKey("1")){
            println("............................i have to be called once!")
            channelGroupMap["1"] = DefaultChannelGroup(GlobalEventExecutor.INSTANCE)
        }

        //make sure there is a room number before adding the client to channel
//        channelGroupMap[client.roomId]?.add(ctx.channel())
        channelGroupMap["1"]?.add(ctx.channel())

        //handshake
        val wsFactory = WebSocketServerHandshakerFactory(getWebSocketLocation(req), null, true)
        handshaker = wsFactory.newHandshaker(req)
        if(handshaker == null){
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel())
        }else{
            handshaker.handshake(ctx.channel(), req)
        }
    }

    private fun handleWebsocketFrame(ctx: ChannelHandlerContext, frame: WebSocketFrame) {
        if(frame is CloseWebSocketFrame){
            handshaker.close(ctx.channel(), frame.retain())
            return
        }
        if(frame is PingWebSocketFrame){
            ctx.channel().write(PongWebSocketFrame(frame.content().retain()))
            return
        }
        if(frame !is TextWebSocketFrame){
            throw UnsupportedOperationException(String.format("%s frame types not supported", frame.javaClass.name))
        }else{
//            var result = ""
//            val sb = StringBuilder()
//            val ipAddr = ctx.channel().remoteAddress().toString()
//            val ipAddrs = ipAddr.split(":")
//            if(ipAddrs.size > 2){
//                for(i in 1 until ipAddrs.size){
//                    sb.append(ipAddrs[i])
//                    sb.append(":")
//                }
//                result = sb.toString().substring(0, sb.toString().length-1)
//            }else{
//                result = ipAddrs[0]
//            }
            println("frame.text(): ${frame.text()}")
//            ctx.channel().writeAndFlush(TextWebSocketFrame(frame.text()))
            channelGroupMap["1"]?.forEach {
                println(it.remoteAddress())
                it.writeAndFlush(TextWebSocketFrame(frame.text()))
            }
        }
    }



    private fun getWebSocketLocation(req: FullHttpRequest): String? {
        val location = req.headers()[HttpHeaderNames.HOST] + WEBSOCKET_PATH
        return "ws://$location"
    }
    private fun sendHttpResponse(ctx: ChannelHandlerContext, req: FullHttpRequest, res: DefaultFullHttpResponse) {
        if(res.status().code() != 200){
            val buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8)
            res.content().writeBytes(buf)
            buf.release()
        }
        val channelFuture = ctx.channel().writeAndFlush(res)
        if(req.protocolVersion().isKeepAliveDefault || res.status().code() != 200){
            channelFuture.addListener(ChannelFutureListener.CLOSE)
        }
    }
}