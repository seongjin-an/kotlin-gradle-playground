package primary

class Mocha: Decorator {
    constructor(coffee: Coffee): super(coffee){

    }

    override fun brewing() {
        super.brewing()
        println(" Adding Mocha syrup")
    }
}