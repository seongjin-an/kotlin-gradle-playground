import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder
import java.nio.charset.StandardCharsets

class NettyDecoder: ByteToMessageDecoder() {
    override fun decode(ctx: ChannelHandlerContext?, `in`: ByteBuf?, out: MutableList<Any>?) {
        println("=======================================invoke decoder")
        println("CHECK POINT1")
        `in`?.markReaderIndex();
        val byteBodyLength = ByteArray(size = 8)
        println("CHECK POINT2 byteBodyLength: $byteBodyLength")
        `in`?.readBytes(byteBodyLength)
        val bodyLength = byteBodyLength.toString().trim()
        println("CHECK POINT3 bodyLength: $bodyLength")
        val byteBody = ByteArray(size = bodyLength.length)
        println("CHECK POINT4 byteBody: $byteBody")
        `in`?.readBytes(byteBody)
        val strBody = byteBody.toString(StandardCharsets.UTF_8)
        println("CHECK POINT5 strBody: $strBody")
        out?.add(strBody)
    }

}