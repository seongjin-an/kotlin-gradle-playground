package calculator

fun main(){
    val calculator: Calculator = Calculator(KrwCalculator());
    println(calculator.sum(10, 20))

    val marketApi = MarketApi()
    val dollarCalculator = DollarCalculator(marketApi)
    dollarCalculator.init()
    val calculator2 = Calculator(dollarCalculator)
    println(calculator2.sum(10, 20))

}