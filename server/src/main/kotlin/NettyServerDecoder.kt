import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder
import java.nio.charset.Charset

class NettyServerDecoder: ByteToMessageDecoder() {
    override fun decode(ctx: ChannelHandlerContext?, `in`: ByteBuf?, out: MutableList<Any>?) {
        println("===============invoke decoder")
        if(`in` == null){
            println("CHECK POINT1")
            return
        }
        if(out == null){
            println("CHECK POINT2")
            return
        }
        try{
            println("CHECK POINT3")
            if(`in`.readableBytes() != 0){
                println("CHECK POINT4")
                val size = `in`.readableBytes()
                val msgBytes = ByteArray(size)
                `in`.readBytes(msgBytes)
                val strBody = msgBytes.toString(Charset.defaultCharset())
                println("strBody: $strBody")
                out.add(strBody)
            }
        }catch(e: Exception){
             println("CHECK POINT5")
            e.printStackTrace()
            return
        }
        println("================END DECODE")
//        println("=======================================invoke decoder")
//        println("CHECK POINT1")
//        `in`?.markReaderIndex();
//        val byteBodyLength = ByteArray(size = 8)
//        println("CHECK POINT2 byteBodyLength: $byteBodyLength")
//        `in`?.readBytes(byteBodyLength)
//        val bodyLength = byteBodyLength.toString().trim()
//        println("CHECK POINT3 bodyLength: $bodyLength")
//        val byteBody = ByteArray(size = bodyLength.length)
//        println("CHECK POINT4 byteBody: $byteBody")
//        `in`?.readBytes(byteBody)
//        val strBody = byteBody.toString(StandardCharsets.UTF_8)
//        println("CHECK POINT5 strBody: $strBody")
//        out?.add(strBody)
    }

}