package second

import primary.EthiopiaAmericano
import primary.KeyaAmericano
import primary.Latte
import primary.Mocha
import primary.WhippingCream

fun main(args: Array<String>){
    println("**************************************")
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