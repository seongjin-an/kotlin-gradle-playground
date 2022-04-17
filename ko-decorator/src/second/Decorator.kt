package second

abstract class Decorator(var coffee: Coffee): Coffee() {
    override fun brewing() {
        coffee.brewing()
    }
}