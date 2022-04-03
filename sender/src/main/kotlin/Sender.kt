import java.io.BufferedOutputStream
import java.io.IOException
import java.net.Socket
import java.nio.charset.StandardCharsets

class Sender {
    companion object{
        fun send(host: String, port:Int, msg: String): Boolean{
            var result = false;
            var client: Socket? = null
            var bos: BufferedOutputStream? = null

            try{
                val message = StringBuilder();
//                message.append(String.format("%-8s", msg.length))
                message.append(msg)

                client = Socket(host, port)
                client.keepAlive = true

                bos = BufferedOutputStream(client.getOutputStream())
                bos.write(message.toString().toByteArray(StandardCharsets.UTF_8))
                bos.flush()
                result = true
            }catch(error: IOException){
                error.printStackTrace()
            }finally {
                if(bos != null){
                    try{
                        bos.close()
                    }catch(error: IOException){
                        error.printStackTrace()
                    }
                }
                if(client != null){
                    try{
                        client.close()
                    }catch(error: IOException){
                        error.printStackTrace()
                    }
                }
            }
            return result
        }
    }
}
fun main(args: Array<String>){
    Sender.send("localhost", 8080, "hello world11")
}