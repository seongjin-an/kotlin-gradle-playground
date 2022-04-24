fun main() {
    val nums: Array<Int> = arrayOf(10, 55, 23, 2, 79, 101, 16, 82, 30, 45)
    var min = nums[0]
    var max = nums[0]
    var minPos = 0;
    var maxPos = 0;
    for(i in 0 until nums.size){
        if( nums[i] < min ){
            min = nums[i]
            minPos = i + 1;
        }
        if( nums[i] > max ) {
            max = nums[i]
            maxPos = i + 1;
        }
    }
    println("min: $min, min index: $minPos")
    println("max: $max, max index: $maxPos")
}