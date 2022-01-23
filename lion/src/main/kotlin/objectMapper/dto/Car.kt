package objectMapper.dto

import com.fasterxml.jackson.annotation.JsonProperty
data class Car(
    var name: String,
    @get:JsonProperty(value = "car_number")
    var carNumber: String,
    @get:JsonProperty(value = "TYPE")
    var type: String
) {
    constructor() : this("","","") {

    }
    override fun toString(): String {
        return "Car(name='$name', carNumber='$carNumber', type='$type')"
    }
}