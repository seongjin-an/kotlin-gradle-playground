data class Person(var name: String, var age: Int, var email: String) 
data class Car(var name: String, var size: Int, var color: String)
fun main(args: Array<String>) {
    var person = Person("ansj", 22, "ansj@eseict.com")
    val person2 = person.also { _person ->
        _person.age = 0
        Car("ansj", 2, "black")
    }//return context
    println("also result person name:${person.name} / age:${person.age} / email:${person.email}")
    println("also result person2 size:${person2.name} / age:${person2.age} / email:${person2.email}")

    val person3 = person.apply {
        age = 1
        Car("ansj", 3, "black")
    }//return context
    println("apply result person name:${person.name} / age:${person.age} / email:${person.email}")
    println("apply result person3 name:${person3.name} / age:${person3.age} / email:${person3.email}")

    val car = person.let { _person ->
        _person.age = 2
        Car("ans", 3, "black")
    }//return lambda result
    println("let result person name:${person.name} / age:${person.age} / email:${person.email}")
    println("let result car name:${car.name} / size:${car.size} / color:${car.color}")

    val car2 = person.run {
        age = 3
        Car("ansj", 4, "black")
    }
    println("run result person name:${person.name} / age:${person.age} / email:${person.email}")
    println("run result car2 name:${car2.name} / size:${car2.size} / color:${car2.color}")

    val car3 = run{
        Car("ansj", 5, "black")
    }
    println("run result car3 name:${car3.name} / size:${car3.size} / color:${car3.color}")

    val car4 = with(car3){
        size=6
        Car("ansj", 7, "black")
    }
    println("with result car3 name:${car3.name} / size:${car3.size} / color:${car3.color}")
    println("with result car4 name:${car4.name} / size:${car4.size} / color:${car4.color}")
}
