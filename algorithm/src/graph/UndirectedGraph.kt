package graph

class UndirectedGraph(count: Int) {
    private var vertexArray: Array<IntArray> = Array(count){ IntArray(count) }

    fun addEdges(from: Int, to: Int, weight: Int){
        vertexArray[from][to] = weight
        vertexArray[to][from] = weight
    }

    fun getMatrix(): Array<IntArray>{
        return vertexArray
    }

}