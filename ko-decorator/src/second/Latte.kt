package second

class Latte(coffee: Coffee): Decorator(coffee) {
    override fun brewing() {
        super.brewing()
        println(" Adding Milk")
    }
}