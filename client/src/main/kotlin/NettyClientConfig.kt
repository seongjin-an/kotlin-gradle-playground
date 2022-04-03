import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import kotlin.system.exitProcess

class NettyClientConfig {
    companion object{
        @Volatile
        private var instance: NettyClientConfig? = null

        @JvmStatic
        fun getInstance(port: Int): NettyClientConfig {
            return instance ?: synchronized(this){
                return instance ?: NettyClientConfig(port).also{ client -> instance = client}
            }
        }
    }

    private var port: Int = 9999
    lateinit var bootstrap: Bootstrap
    lateinit var group: EventLoopGroup
    private constructor()
    private constructor(port: Int){
        this.port = port
    }

    fun initializeClient(){
        println("initialize client...")
        group = NioEventLoopGroup()
        try{
            bootstrap = Bootstrap()
            bootstrap.group(group)
                .channel(NioSocketChannel::class.java)
                .remoteAddress("localhost", this.port)
                .handler(object: ChannelInitializer<SocketChannel>(){
                    override fun initChannel(ch: SocketChannel) {
                        val channelPipeline = ch.pipeline()
                            .addLast("decoder", NettyClientDecoder())
                            .addLast("encoder", NettyClientEncoder())
                            .addLast("handler", NettyClientHandler())
                    }
                })
            val fText = bootstrap.connect("localhost", 8080)
            fText.channel().closeFuture().sync()
        }catch(error: InterruptedException){
            error.printStackTrace()
            exitProcess(1)
        }finally{
            group.shutdownGracefully()
        }
    }
}