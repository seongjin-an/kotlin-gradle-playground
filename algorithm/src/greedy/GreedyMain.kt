package greedy

fun main() {
    val coins = arrayOf(500, 100, 50, 10)
    var price = 8370
    var count = 0
    (0 until coins.size).forEach { i ->
        count = 0
        count += price / coins[i]
        price %= coins[i]
        println("${coins[i]}짜리 동전 $count 필요함")
    }
}