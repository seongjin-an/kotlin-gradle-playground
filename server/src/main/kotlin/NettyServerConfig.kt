import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import kotlin.system.exitProcess

class NettyServerConfig {
    companion object {
        @Volatile
        private var instance: NettyServerConfig? = null

        @JvmStatic
        fun getInstance(port: Int): NettyServerConfig {
            return instance ?: synchronized(this){
                instance ?: NettyServerConfig(port).also{ server -> instance = server}
            }
        }
    }

    private var port: Int = 8888;
    lateinit var serverBootstrap: ServerBootstrap
    lateinit var bossGroup: EventLoopGroup
    lateinit var workerGroup: EventLoopGroup
    private constructor()
    private constructor(port: Int){
        this.port = port
    }

    fun initializeServer(){
        println("initialize server...")
        bossGroup = NioEventLoopGroup()
        workerGroup = NioEventLoopGroup()
        try{
            serverBootstrap = ServerBootstrap()
            serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel::class.java)
                .childHandler(object: ChannelInitializer<SocketChannel>(){
                    override fun initChannel(ch: SocketChannel) {
                        println("=======================INITIALIZE CHANNEL")
                        val channelPipeline = ch.pipeline()
                            .addLast("decoder", NettyServerDecoder())
                            .addLast("encoder", NettyServerEncoder())
                            .addLast("handler", NettyServerHandler())

//                        channelPipeline.addLast("logging", LoggingHandler(LogLevel.INFO))
//                        channelPipeline.addLast("handler", NettyHandler())
//                        channelPipeline.addLast("decoder", NettyDecoder())
//                        channelPipeline.addLast("encoder", NettyEncoder())
//                        channelPipeline.addLast("decoder", StringDecoder())
//                        channelPipeline.addLast("encoder", StringEncoder())
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.SO_LINGER, 0)
            val fText = serverBootstrap.bind(this.port)
            fText.channel().closeFuture().sync()
        }catch(error: InterruptedException){
            exitProcess(1)
        }finally {
            workerGroup.shutdownGracefully()
            bossGroup.shutdownGracefully()
        }
    }
}