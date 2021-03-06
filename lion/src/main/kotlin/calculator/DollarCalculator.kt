package calculator

class DollarCalculator(val marketApi: MarketApi) : ICalculator {
    var price:Int = 1;

    fun init(){
        this.price = marketApi.connect()
    }

    override fun sum(x: Int, y: Int): Int {
        return (x*price) + (y*price)
    }

    override fun minus(x: Int, y: Int): Int {
        return (x*price) - (y*price)
    }

}