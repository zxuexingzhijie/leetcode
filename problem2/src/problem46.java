// LeetCode题目链接: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
public class problem46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);
        treeNode.left.right.left = new TreeNode(7);
        treeNode.left.right.right = new TreeNode(4);

        // 传入树中已有节点的引用（比如 p = treeNode.left (5)， q = treeNode.right (1)）
        TreeNode p = treeNode.left;   // 值为 5 的已有节点
        TreeNode q = treeNode.right;  // 值为 1 的已有节点
        TreeNode res = solution46.lowestCommonAncestor(treeNode, p, q);
        System.out.println(res.val);
    }
}

class Solution46 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }

        if (root == p || root == q ){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left != null && right != null){
            return root;
        }

        return left == null?right:left;
    }
}

//详细追踪一：p=5, q=1（两节点分别在根的左右子树）
//
//我们从 root=3 开始。
//
//调用栈（按顺序展开）与返回结果：
//
//LCA(3,5,1)：
//
//root != null 且 root != p/q → 继续
//
//调左子树：left = LCA(5,5,1)
//
//LCA(5,5,1)：
//
//root == p（5） → 直接返回 5（不再继续往下查找）
//
//所以 left = 5（回到 root=3）
//
//LCA(3,5,1) 继续：
//
//调右子树：right = LCA(1,5,1)
//
//LCA(1,5,1)：
//
//root == q（1） → 直接返回 1
//
//所以 right = 1（回到 root=3）
//
//LCA(3,5,1) 收到 left=5 和 right=1，两边都非空 → return 3
//
//结论：根 3 同时从左右得到“找到了目标”的返回，这表示 3 是首次将 p 和 q 分到不同子树的节点，所以是 LCA。
//
//关键点：当 LCA(5,5,1) 发现 root==p 就立刻返回 5，这充当了“左子树找到了目标”的信号。不会继续搜索 5 的子孙（因为 5 本身就是一个目标）。
//
//详细追踪二：p=5, q=4（p 是 q 的祖先）
//
//现在 p=5，q=4（4 在 5 的子树里）。按理 LCA 应该是 5（因为 5 是 4 的祖先）。
//
//调用栈与返回：
//
//LCA(3,5,4)：
//
//root != p/q → 调左子树 left = LCA(5,5,4)
//
//LCA(5,5,4)：
//
//root == p（5） → 立即返回 5（重要：一旦找到目标节点 p，就把它上报；上报的含义是“在我这棵子树找到了 p（可能也是 q 的祖先）”）
//
//所以 left = 5（回到 root=3）
//
//LCA(3,5,4) 继续：
//
//调右子树 right = LCA(1,5,4)。右子树既不含 5 也不含 4，最终 right = null。
//
//LCA(3,5,4) 收到 left=5, right=null → 返回 left（也就是 5）。
//
//结论：5 被当作“信号”传上来，根节点 3 看到右边没有匹配，只把左边的 5 继续上报，所以最终 LCA 是 5。这满足“若一个节点是另一个的祖先，则祖先就是 LCA”的直观结论。
//
//为什么遇到 root==p 或 root==q 要立即返回？
//
//把它看成一种布尔/指示信号：
//
//返回 null 表示“在这棵子树里没找到任何目标”；
//
//返回 非空节点（且该节点要么是 p/q，要么是它们的 LCA）表示“在这棵子树里找到了目标（或它们的 LCA）”。
//
//当 root==p（或 q）时：
//
//我们已经找到了目标节点，所以当前子树“至少”包含目标（不需要继续找这个分支里其他节点来证实）。
//
//而且如果同一节点的另一个目标在其某个子孙中（p 是 q 的祖先的情况），这种返回会传播上去，在上层配合另一个分支的返回作出判断。
//
//如果不立即返回而继续在子树中寻找，会浪费时间，并且会复杂化信号传递（实际上没有必要）。