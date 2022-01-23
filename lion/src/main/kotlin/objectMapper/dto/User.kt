package objectMapper.dto

class User {
    var name: String = "";
    var age: Int = 0;
    var cars: List<Car>? = null;

    constructor(){

    }

    constructor(name: String, age: Int, cars: List<Car>){
        this.name = name
        this.age = age
        this.cars = cars
    }

    override fun toString(): String {
        return "User(name='$name', age=$age, cars=$cars)"
    }
}