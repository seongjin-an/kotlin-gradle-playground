import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import objectMapper.dto.Car
import objectMapper.dto.User

fun main(args: Array<String>){
    println("main")
    val objectMapper = ObjectMapper();

    val user = User()
    user.name = "홍길동"
    user.age = 10

    val car1 = Car()
    car1.name="K5"
    car1.carNumber = "11가 1111"
    car1.type = "sedan"

    val car2 = Car()
    car2.name="Q5"
    car2.carNumber = "22가 2222"
    car2.type = "SUV"

    user.cars = listOf(car1, car2)

    println("user: $user")

    val json = objectMapper.writeValueAsString(user)
    println(json)

    val jsonNode: JsonNode = objectMapper.readTree(json)
    val _name: String = jsonNode.get("name").asText()
    val _age:Int = jsonNode.get("age").asInt()
    
    var cars:JsonNode = jsonNode.get("cars")
//    var arrayNode = ArrayNode::class.java.cast(cars)
    var arrayNode = cars as ArrayNode
    var _cars = objectMapper.convertValue(arrayNode, object:TypeReference<List<Car>>(){})
    println("_name: $_name / _age: $_age / _cars: $_cars")

    val objectNode: ObjectNode = jsonNode as ObjectNode
    objectNode.put("name", "steve")
    objectNode.put("age", 20)

    println(objectNode.toPrettyString())
}