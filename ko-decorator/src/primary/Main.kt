package primary

fun main(args: Array<String>){
    val ethiopiaAmericano = EthiopiaAmericano()
    ethiopiaAmericano.brewing()
    println()

    val ethiopiaLatte = Latte(ethiopiaAmericano)
    ethiopiaLatte.brewing()
    println()

    val mochaEthiopia = Mocha(Latte(EthiopiaAmericano()))
    mochaEthiopia.brewing()
    println()

    val mochaEthiopia2 = Mocha(ethiopiaLatte)
    mochaEthiopia2.brewing()
    println()

    val keyaCoffee = WhippingCream(Mocha(KeyaAmericano()))
    keyaCoffee.brewing()
}