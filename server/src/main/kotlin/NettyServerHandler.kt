import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.group.DefaultChannelGroup
import io.netty.util.concurrent.GlobalEventExecutor

class NettyServerHandler: ChannelInboundHandlerAdapter() {
    companion object{
        val channelGroup = DefaultChannelGroup(GlobalEventExecutor.INSTANCE)
        val rooms = HashMap<String, MutableList<Channel>>()
        var TEST_ROOM = 0
    }
    private val ROOM_ODD = "odd"
    private val ROOM_EVEN = "even"

    override fun channelRegistered(ctx: ChannelHandlerContext?) {
        TEST_ROOM++
        val channel = ctx?.channel()
        channelGroup.add(channel)
        val roomType = if(TEST_ROOM % 2 == 0) ROOM_EVEN else ROOM_ODD
        if(rooms[roomType] == null){
            println("$roomType REGISTERED...")
            val channels = mutableListOf(channel!!)
            rooms[roomType] = channels
        }else{
            println("$roomType EXISTS ALREADY")
            rooms[roomType]!!.add(channel!!)
        }
//        rooms[roomType]?.forEach { room ->  println(room) }
        println("[channelRegistered]: ${channel.remoteAddress()}")
//        channelGroup.forEach { group -> group.writeAndFlush("[SERVER]: ${channel.remoteAddress()} LOGIN\n") }
        rooms[roomType]?.forEach { chn ->  chn.writeAndFlush("[SERVER]: ${channel.remoteAddress()} LOGIN\\n")}
    }

    override fun channelUnregistered(ctx: ChannelHandlerContext?) {
        val oldChannel = ctx?.channel()
        channelGroup.remove(oldChannel)
        val roomType = if(TEST_ROOM % 2 == 0) ROOM_EVEN else ROOM_ODD
        if(rooms[roomType] != null){
            rooms[roomType]!!.remove(oldChannel)
        }
//        println("[channelUnregistered]: ${oldChannel!!.remoteAddress()}")
//        channelGroup.forEach { group -> group.writeAndFlush("[SERVER]: ${oldChannel.remoteAddress()} LOGOUT\n") }
        rooms[roomType]?.forEach { chn -> chn.writeAndFlush("[SERVER]: ${oldChannel?.remoteAddress()} LOGOUT\\n") }
    }
    override fun handlerAdded(ctx: ChannelHandlerContext?) {
        val incoming: Channel = ctx!!.channel()
        println(incoming.remoteAddress().toString().plus(" JOIN"))
    }

    override fun channelActive(ctx: ChannelHandlerContext) {
        val channel = ctx.channel()
        println("[NEW CLIENT] remote address: ${channel.remoteAddress()}")
    }

    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        var message: String? = null
        message = msg.toString()
//        message = ((msg as ByteBuf).toString(StandardCharsets.UTF_8))
//        message = ((msg as ByteBuf).toString(Charset.defaultCharset()))
        println("[channelRead]: $message")
        val channel = ctx.channel()
        val roomType = if(TEST_ROOM % 2 == 0) ROOM_EVEN else ROOM_ODD
        if(rooms[roomType] != null){
            val channels = rooms[roomType]!!
            channels.forEach { _channel ->
                println("CHANNEL: ${_channel.remoteAddress()}")
                _channel.writeAndFlush("[${channel.remoteAddress()}]: $message\n")
            }
        }
    }

    override fun channelReadComplete(ctx: ChannelHandlerContext?) {
        ctx?.flush()
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext?, cause: Throwable?) {
        cause?.printStackTrace()
        ctx?.close()
    }
}