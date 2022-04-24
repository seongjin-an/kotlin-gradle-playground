package sort

class InsertSort {
    companion object {
        fun insertionSort(arr: Array<Int>, count: Int){
            var (x, temp) = listOf(0,0,0)

            for(i in 1 until count){
                temp = arr[i]
                x = i
                while((x > 0) && (arr[x - 1] > temp)) {
                    arr[x] = arr[x - 1]
                    x -= 1
                }
                arr[x] = temp
                println("반복 -$i")
                printSort(arr, count)
            }
        }

        private fun printSort(value: Array<Int>, count: Int) {
            for(i in 0 until count){
                print("${value[i]}\t")
            }
            println()
        }
    }
}
fun main(){
    val arr = arrayOf(80, 50, 70, 10, 60, 20, 40, 30)
    InsertSort.insertionSort(arr, arr.size)
}