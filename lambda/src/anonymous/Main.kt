package anonymous

fun main(args: Array<String>){
    val calculator: Calculator = object: Calculator {
        override fun add(x: Int, y: Int): Int {
            return x + y
        }
    }
    val runnable = Runnable { println("lambda good!")}
    runnable.run()

    val intPredicate = object : IntPredicate {
        override fun accept(i: Int): Boolean {
            return i % 2 == 0
        }
    }

    val button = Button("ansj", object: IButton{
        override fun clickEvent(event: String) {
            println("event: $event")
        }
    })
    button.click("hello there")

}