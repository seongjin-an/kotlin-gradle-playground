package tree

class TreeNode(val value: String) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun visit(root: TreeNode?){
    if(root == null){
        return
    }
    println(root.value)
    visit(root.left)
    visit(root.right)
}

fun main(){
    val node0 = TreeNode("NODE-0")
    val node1 = TreeNode("NODE-1")
    val node2 = TreeNode("NODE-2")
    val node3 = TreeNode("NODE-3")
    val node4 = TreeNode("NODE-4")
    val node5 = TreeNode("NODE-5")
    val node6 = TreeNode("NODE-6")
    val node7 = TreeNode("NODE-7")
    val node8 = TreeNode("NODE-8")
    val node9 = TreeNode("NODE-9")

    node0.left = node1
    node1.left = node2
    node1.right = node3
    node3.right = node4
    node0.right = node5
    node5.left = node6
    node6.right = node7
    node5.right = node8
    node8.left = node9

    visit(node0)
}
/*
               n0
         n1          n5
     n2     n3    n6     n8
              n4    n7 n9
 */
/*  전위 순회(Preorder Traversal)
    전위 순회는 깊이 우선순회(DFT, Depth-First Traversal) 이라고도 한다.
    트리를 복사하거나, 전위 표기법을 구하는데 주로 사용한다.
    트리를 복사할 때 전위 순회를 사용하는 이유는 트리를 생성할 때 자식 노드보다 부모 노드가 먼전 생성되어야 하기 때문이다.
    전위 순회는 1.ROOT 노드 방문 2.왼쪽 서브 트리 전위 순회 3.오른쪽 서브 트리 전위 순회 순서로 진행한다.
    n0 -> n1 -> n2 -> n3 -> n4 -> n5 -> n6 -> n7 -> n8 -> n9
 */
/*  중위 순회(Inorder Traversal)
    중위 순회는 왼쪽 오른쪽 대칭 순서로 순회를 하기때문에 대칭 순회(Symmetric Traversal) 이라고도 한다.
    중위 순회는 이진 탐색트리(BST) 에서 오름차순 또는 내림차순으로 값을 가져올 때 사용된다.
    내림 차순으로 값을 가져오기 위해서는 역순(오른쪽 -> ROOT -> 왼쪽)으로 중위 순회를 하면 된다.
    중위 순회는 1.왼쪽 서브 트리 중위 순회 2.ROOT 노드 방문 3.오른쪽 서브트리 중위 순회 순서로 진행한다.
    n2 -> n1 -> n3 -> n4 -> n0 -> n6 -> n7 -> n5 -> n9 -> n8
 */
/*  후위 순회(Postorder Traversal)
    후위 순회는 트리를 삭제하는데 주로 사용된다.
    이유는 부모노드를 삭제하기 전에 자식 노드를 삭제하는 순으로 노드를 삭제해야 하기 때문이다.
    후위 순회는 1.왼쪽 서브트리 후위 순회 2.오른쪽 서브 트리 후위 순회 3.ROOT 노드 방문 순서로 진행한다.
    n2 -> n4 -> n3 -> n1 -> n7 -> n6 -> n9 -> n8 -> n5 -> n0
 */


