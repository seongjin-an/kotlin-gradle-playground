package sort

class BfsSearch(private val count: Int) {
    private var visited: BooleanArray = BooleanArray(count)
    private var queue = mutableListOf<Int>()
    lateinit var matrix: Array<IntArray>

    fun bfsTraversal(){
        queue.add(0)
        visited[0] = true

        while(queue.size != 0){
            val node: Int = queue.removeAt(0)
            print("$node ")
            for(j in 0 until count){
                if(matrix[node][j] != 0 && !visited[j]){
                    queue.add(j)
                    visited[j] = true
                }
            }
        }
    }
}