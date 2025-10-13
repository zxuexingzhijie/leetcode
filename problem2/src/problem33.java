public class problem33 {
    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int result = solution33.maxDepth(root);
        System.out.println(result); // Output: 3
    }
}

/**
 * maxDepth(3)
 *  ├── maxDepth(9)
 *  │    ├── maxDepth(null) = 0
 *  │    ├── maxDepth(null) = 0
 *  │    └── return 1
 *  └── maxDepth(20)
 *       ├── maxDepth(15)
 *       │    ├── maxDepth(null) = 0
 *       │    ├── maxDepth(null) = 0
 *       │    └── return 1
 *       ├── maxDepth(7)
 *       │    ├── maxDepth(null) = 0
 *       │    ├── maxDepth(null) = 0
 *       │    └── return 1
 *       └── return 2
 * → 最终返回 3
 */

class Solution33 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        return Math.max(leftdepth, rightdepth) + 1;
    }
}



// Another approach using DFS and a class variable to track max depth
//class Solution33 {
//    private int maxDepth = 0;
//
//    public int maxDepth(TreeNode root) {
//        dfs(root, 0);
//        return maxDepth;
//    }
//
//    private void dfs(TreeNode node, int depth) {
//        if (node == null) {
//            maxDepth = Math.max(maxDepth, depth);
//            return;
//        }
//        dfs(node.left, depth + 1);
//        dfs(node.right, depth + 1);
//    }
//}
