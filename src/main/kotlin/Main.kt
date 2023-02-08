fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)
    Solution(root).printLevelOrder()
}

class Solution(private val root: TreeNode?) {
    private var list = ArrayList<ArrayList<Int>>()
    private var innerList = ArrayList<Int>()
    fun printLevelOrder() {
        val h = height(root)
        var i = 1
        while (i <= h) {
            printCurrentLevel(root, i)
            i++
            list.add(innerList)
            innerList = ArrayList()
        }
    }

    private fun height(root: TreeNode?): Int {
        return if (root == null) 0 else {
            val lHeight = height(root.left)
            val rHeight = height(root.right)

            if (lHeight > rHeight) lHeight + 1 else rHeight + 1
        }
    }

    private fun printCurrentLevel(root: TreeNode?, level: Int) {
        if (root == null) return
        if (level == 1) {
            innerList.add(root.`val`)
            print(root.`val`.toString() + " ")
        } else if (level > 1) {
            printCurrentLevel(root.left, level - 1)
            printCurrentLevel(root.right, level - 1)
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
