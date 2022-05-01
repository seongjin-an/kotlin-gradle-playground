package graph

//최단거리 찾기 Dijkstra의 최단 경로 알고리즘
class Graph(val count: Int) {
    private var vertexMatrix = Array(count){ IntArray(count) }
    private var distance = Array(count) { 0 }
    private var visited = BooleanArray(count)
    private val UNLIMIT = 999999

    fun addEdges(from: Int, to: Int, weight: Int){
        vertexMatrix[from][to] = weight
        vertexMatrix[to][from] = weight
    }

    fun calcShortestPath(from: Int){
        (0 until count).forEach { distance[it] = UNLIMIT }
        visited[from] = true
        distance[from] = 0

        (0 until count).forEach {
            if(visited[from] && vertexMatrix[from][it] != 0) distance[it] = vertexMatrix[from][it]
        }
        // from 은 처음 하나가 정해진 상황이므로 빼기 1을 한다.
        (0 until count - 1).forEach { i ->
            var min = UNLIMIT
            var minIndex = -1
            (0 until count).forEach { j ->
//                println("i: $i / j: $j / minIndex: $minIndex")
                if(!visited[j] && distance[j] != UNLIMIT){
                    if(distance[j] < min) {

                        min= distance[j]
                        minIndex = j
//                        println("min: $min / minIndex: $minIndex")
                    }
                }
            }
            visited[minIndex] = true
            (0 until count).forEach { k ->
//                println("i: $i / k: $k")
                if(!visited[k] && vertexMatrix[minIndex][k] != 0){
                    if(distance[k] > distance[minIndex] + vertexMatrix[minIndex][k]){
                        distance[k] = distance[minIndex] + vertexMatrix[minIndex][k]
                    }
                }
            }
        }
    }

    fun showDistance(from: Int){
        (0 until count).forEach { i ->
            println("shortest distance from node $from to node $i is ${distance[i]}")
        }
    }

}

fun main() {
    val graph = Graph(6)
    graph.addEdges(0, 1, 1)
    graph.addEdges(0, 2, 4)
    graph.addEdges(1, 2, 2)
    graph.addEdges(2, 3, 1)
    graph.addEdges(3, 4, 8)
    graph.addEdges(3, 5, 3)
    graph.addEdges(4, 5, 4)

    graph.calcShortestPath(0)
    graph.showDistance(0)
}