import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter

class NettyClientHandler: ChannelInboundHandlerAdapter() {
    override fun channelActive(ctx: ChannelHandlerContext) {
        val msg = "hello from client"
        ctx.writeAndFlush(msg)
    }
    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        val sb = StringBuilder()
        sb.append("[receive message]: $msg")
        println(sb.toString())
    }
    override fun channelReadComplete(ctx: ChannelHandlerContext?) {
        ctx?.flush()
    }
    override fun exceptionCaught(ctx: ChannelHandlerContext?, cause: Throwable?) {
        cause?.printStackTrace()
        ctx?.close()
    }
}