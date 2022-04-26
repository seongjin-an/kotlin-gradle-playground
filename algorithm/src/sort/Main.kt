package sort

fun main() {

    val count = 8
    val graph = UndirectedGraph(count)
    graph.addEdges(0, 1, 1)
    graph.addEdges(0, 2, 1)
    graph.addEdges(1, 3, 1)
    graph.addEdges(1, 4, 1)
    graph.addEdges(2, 5, 1)
    graph.addEdges(2, 6, 1)
    graph.addEdges(4, 5, 1)
    graph.addEdges(3, 7, 1)

    val dfs = DfsSearch(count)
    dfs.matrix = graph.getMatrix()

    dfs.dfsTraversal()

    //////////////////////////////////////////////
    println()
    val bfs = BfsSearch(count)
    bfs.matrix = graph.getMatrix()
    bfs.bfsTraversal()
}
// 0 2 6 5 4 1 3 7
//             0
//           /   \
//         1       2
//       /  \     / \
//     3     4 - 5   6
//   /
// 7