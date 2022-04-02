import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToByteEncoder

class NettyEncoder: MessageToByteEncoder<Any>() {
    override fun encode(ctx: ChannelHandlerContext?, msg: Any?, out: ByteBuf?) {
        out?.writeBytes(msg.toString().encodeToByteArray())
    }

}