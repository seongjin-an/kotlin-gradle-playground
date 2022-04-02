fun main(args: Array<String>){
    val nettyServer = NettyServer.getInstance(8080)
    nettyServer.initializeServer()
}