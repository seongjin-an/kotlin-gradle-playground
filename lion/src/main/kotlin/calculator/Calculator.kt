package calculator

class Calculator(
    val iCalculator: ICalculator
){
    fun sum(x:Int, y:Int):Int{
        return this.iCalculator.sum(x, y)
    }
    fun minus(x: Int, y: Int): Int{
        return this.iCalculator.minus(x, y)
    }
}