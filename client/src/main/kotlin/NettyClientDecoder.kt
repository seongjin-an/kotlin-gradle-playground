import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder
import java.nio.charset.Charset

class NettyClientDecoder: ByteToMessageDecoder() {
    override fun decode(ctx: ChannelHandlerContext?, `in`: ByteBuf?, out: MutableList<Any>?) {
        if(`in` == null){
            return
        }
        if(out == null){
            return
        }
        try{
            if(`in`.readableBytes() != 0){
                val size = `in`.readableBytes()
                val msgBytes = ByteArray(size)
                `in`.readBytes(msgBytes)
                val strBody = msgBytes.toString(Charset.defaultCharset())
                out.add(strBody)
            }
        }catch(e: Exception){
            e.printStackTrace()
            return
        }
    }
}