package sort

class HeapSort {
    private var SIZE: Int
    private var heapArr: IntArray

    init {
        this.SIZE = 0
        this.heapArr = IntArray(50)
    }

    fun insertHeap(input: Int){
        var i = ++SIZE
        while((i != 1) && (input > heapArr[i/2])) { // max heap
//        while((i != 1) && (input < heapArr[i/2])) { // min heap
            heapArr[i] = heapArr[i/2]
            i /= 2
        }
        heapArr[i] = input
    }
    fun getHeapSize(): Int {
        return SIZE
    }

    fun deleteHeap(): Int {
        var parent = 0
        var child = 0
        var data = heapArr[1]
        var temp = heapArr[SIZE]

        this.SIZE -= 1
        parent = 1
        child = 2

        while(child <= SIZE){
            if((child < SIZE) &&(heapArr[child] < heapArr[child + 1])) { // max heap
//            if((child < SIZE) && (heapArr[child] > heapArr[child + 1])) { // min heap
                child++
            }
            if(temp >= heapArr[child]) break // max heap
//            if(temp <= heapArr[child]) break // min heap
            heapArr[parent] = heapArr[child]
            parent = child
            child *= 2
        }
        heapArr[parent] = temp
        return data
    }

    fun printHeap(): Unit{
        print("Min Heap: ")
        for(i in 1..SIZE){
            print("[${heapArr[i]}] ")
        }
        println()
    }
}

fun main(){
    val h = HeapSort()
    h.insertHeap(80)
    h.insertHeap(50)
    h.insertHeap(70)
    h.insertHeap(10)
    h.insertHeap(60)
    h.insertHeap(20)

    h.printHeap()

    var (n, data) = arrayOf(0, 0)
    n = h.getHeapSize()
    for(i in 1..n){
        data = h.deleteHeap()
        println("출력: [$data]")
    }
}