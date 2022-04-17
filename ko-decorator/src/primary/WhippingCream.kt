package primary

class WhippingCream: Decorator {
    constructor(coffee: Coffee): super(coffee)

    override fun brewing() {
        super.brewing()
        println(" Adding Whipping Cream")
    }
}