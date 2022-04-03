import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.http.HttpObjectAggregator
import io.netty.handler.codec.http.HttpServerCodec
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler
import kotlin.system.exitProcess

class NettyWebsocketServerConfig {
    companion object {
        @Volatile
        private var instance: NettyWebsocketServerConfig? = null

        @JvmStatic
        fun getInstance(port: Int): NettyWebsocketServerConfig {
            return instance ?: synchronized(this){
                instance ?: NettyWebsocketServerConfig(port).also{ server -> instance = server}
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

    fun initializeServer() {
        println("initialize server...")
        bossGroup = NioEventLoopGroup()
        workerGroup = NioEventLoopGroup()
        try {
            serverBootstrap = ServerBootstrap()
            serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel::class.java)
                .childHandler(object : ChannelInitializer<SocketChannel>() {
                    override fun initChannel(ch: SocketChannel) {
                        println("=======================INITIALIZE CHANNEL")
                        val channelPipeline = ch.pipeline()
                            .addLast(HttpServerCodec())
                            .addLast(HttpObjectAggregator(65536))
                            .addLast(WebSocketServerCompressionHandler())
                            .addLast(NettyWebsocketServerHandler())
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.SO_LINGER, 0)
            val fText = serverBootstrap.bind(this.port)
            fText.channel().closeFuture().sync()
        } catch (error: InterruptedException) {
            exitProcess(1)
        } finally {
//            workerGroup.shutdownGracefully()
//            bossGroup.shutdownGracefully()
        }
    }
    fun destroyServer(){
        workerGroup.shutdownGracefully()
        bossGroup.shutdownGracefully()
    }
}