import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToByteEncoder

class NettyServerEncoder: MessageToByteEncoder<Any>() {
    override fun encode(ctx: ChannelHandlerContext?, msg: Any?, out: ByteBuf?) {
        if(msg == null || out == null){
            return
        }
        out.writeBytes(msg.toString().encodeToByteArray())
    }

}