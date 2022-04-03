 fun main(args: Array<String>){
     val nettyClientConfig = NettyClientConfig.getInstance(9090)
     nettyClientConfig.initializeClient()
 }