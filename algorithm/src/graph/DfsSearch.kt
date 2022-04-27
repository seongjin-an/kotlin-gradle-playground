package graph

import java.util.Stack

class DfsSearch(private val count: Int) {
    private var visited: BooleanArray = BooleanArray(count)
    private var stack: Stack<Int> = Stack<Int>()
    lateinit var matrix: Array<IntArray>

    fun dfsTraversal(){
        stack.push(0)
        visited[0] = true

        while(stack.isNotEmpty()){
            val node = stack.pop()
            print("$node ")
            for(j in 0 until count){
                if(matrix[node][j] != 0 && !visited[j]){
                    stack.push(j)
                    visited[j] = true
                }
            }
        }
    }
}