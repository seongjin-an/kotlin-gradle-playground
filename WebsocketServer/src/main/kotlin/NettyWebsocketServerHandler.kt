import entity.Client
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.group.ChannelGroup
import io.netty.channel.group.DefaultChannelGroup
import io.netty.handler.codec.http.*
import io.netty.handler.codec.http.websocketx.WebSocketFrame
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory
import io.netty.util.CharsetUtil
import io.netty.util.concurrent.GlobalEventExecutor
import service.RequestService
import java.util.concurrent.ConcurrentHashMap


class NettyWebsocketServerHandler: ChannelInboundHandlerAdapter() {

    private val HTTP_REQUEST_STRING = "request"
    private val WEBSOCKET_PATH = "/websocket"

    private val channelGroupMap: MutableMap<String, ChannelGroup> = ConcurrentHashMap()
    private lateinit var client: Client
    private lateinit var handshaker: WebSocketServerHandshaker

    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        if(msg is FullHttpRequest){
            handleHttpRequest(ctx, msg)
        }else if(msg is WebSocketFrame){
            handleWebsocketFrame(ctx, msg)
        }
    }

    override fun channelReadComplete(ctx: ChannelHandlerContext?) {
        ctx?.flush()
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext?, cause: Throwable?) {
        cause?.printStackTrace()
        ctx?.close()
    }

    override fun handlerAdded(ctx: ChannelHandlerContext?) {
        val channel = ctx?.channel()
        println("${channel?.remoteAddress()} JOIN")
    }

    override fun handlerRemoved(ctx: ChannelHandlerContext?) {
        if(channelGroupMap.containsKey(client.roomId)){
            channelGroupMap[client.roomId]?.remove(ctx?.channel())
        }
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
        if(parameters.isEmpty() || !parameters.containsKey(HTTP_REQUEST_STRING)){
            System.err.println("$HTTP_REQUEST_STRING You cannot set parameters to their default values.")
            sendHttpResponse(ctx, req, DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND))
            return
        }

        client = RequestService.registerClient(parameters[HTTP_REQUEST_STRING]?.get(0)!!)
        if(client.roomId == ""){
            System.err.println("Room Number cannot be defaulted")
            sendHttpResponse(ctx, req, DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND))
            return
        }

        //If it does not exist in the room list, it is the channel, then add a new channel to channelGroup
        if(!channelGroupMap.containsKey(client.roomId)){
            channelGroupMap[client.roomId] = DefaultChannelGroup(GlobalEventExecutor.INSTANCE)
        }

        //make sure there is a room number before adding the client to channel
        channelGroupMap[client.roomId]?.add(ctx.channel())

        //handshake
        val wsFactory = WebSocketServerHandshakerFactory(getWebSocketLocation(req), null, true)
        handshaker = wsFactory.newHandshaker(req)
        if(handshaker == null){
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel())
        }else{
            val channelFuture = handshaker.handshake(ctx.channel(), req)

            if(channelFuture.isSuccess){
                if(client.id == ""){
                    println("${ctx.channel()} visit")
                    return
                }
            }
        }
    }

    private fun handleWebsocketFrame(ctx: ChannelHandlerContext, msg: WebSocketFrame) {

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