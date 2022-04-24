fun main(){
    val nums = arrayOf(12, 25, 31, 48, 54, 66, 70, 83, 95, 108)
    var target = 83
    var left = 0
    var right = nums.size - 1
    var mid = (left + right) / 2

    var temp = nums[mid]
    var find = false

    while(left <= right){
        if(target == temp) {
            find = true
            break
        }else if(target < temp) {
            right = mid - 1
        }else{
            left = mid + 1
        }
        mid = (left + right) / 2
        temp = nums[mid]
    }

    if(find){
        mid++
        println("찾는 수: $mid 번째")
    }else{
        println("없음")
    }
}