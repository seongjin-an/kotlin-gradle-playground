package primary

class Latte: Decorator {
    constructor(coffee: Coffee) : super(coffee) {
    }

    override fun brewing() {
        super.brewing()
        println(" Adding Milk")
    }
}