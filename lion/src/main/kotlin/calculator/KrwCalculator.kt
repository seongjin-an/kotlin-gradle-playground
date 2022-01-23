package calculator

class KrwCalculator(
    var price: Int = 1
): ICalculator{
    constructor() : this(1) {

    }
    override fun sum(x: Int, y: Int): Int {
        return (x*price) + (y*price)
    }

    override fun minus(x: Int, y: Int): Int {
        return (x*price) - (y*price)
    }

}