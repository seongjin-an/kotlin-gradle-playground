package primary

abstract class Decorator: Coffee {
    lateinit var coffee: Coffee
    constructor(coffee: Coffee) {
        this.coffee = coffee
    }
    override fun brewing() {
        coffee.brewing()
    }
}