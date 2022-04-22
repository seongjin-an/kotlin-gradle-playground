fun main() {
    val nums: Array<Int> = arrayOf(10, 55, 23, 2, 79, 101, 16, 82, 30, 45)
    var min = nums[0]
    var max = nums[0]
    for(i in 0 until nums.size){
        if( nums[i] < min ){
            min = nums[i]
        }
        if( nums[i] > max ) {
            max = nums[i]
        }
    }
    println("min: $min")
    println("max: $max")
}