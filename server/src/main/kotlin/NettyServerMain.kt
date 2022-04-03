fun main(args: Array<String>){
    val nettyServerConfig = NettyServerConfig.getInstance(8080)
    nettyServerConfig.initializeServer()
}