package second

class Mocha(coffee: Coffee): Decorator(coffee) {
    override fun brewing() {
        super.brewing()
        println(" Adding Mocha syrup")
    }
}