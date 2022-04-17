package second

class WhippingCream(coffee: Coffee): Decorator(coffee) {
    override fun brewing() {
        super.brewing()
        println(" Adding Whipping Cream")
    }
}