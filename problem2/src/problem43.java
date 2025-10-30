// LeetCode题目链接: https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
import java.util.*;

public class problem43 {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(6);
        solution43.flatten(treeNode);
    }
}


class Solution43 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // 1. 递归展开左右子树
        flatten(root.left);
        flatten(root.right);

        // 2. 暂存右子树
        TreeNode tempRight = root.right;

        // 3. 把左子树搬到右边
        root.right = root.left;
        root.left = null;

        // 4. 找到新的右子树的最后一个节点
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }

        // 5. 把原来的右子树接上去
        cur.right = tempRight;
    }
}

