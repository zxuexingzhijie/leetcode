// LeetCode题目链接: https://leetcode.cn/problems/binary-tree-level-order-traversal/
import java.util.ArrayList;
import java.util.List;

public class problem37 {
    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> result = solution37.levelOrder(root);
        System.out.println(result);
        // Output: [[1], [2, 3], [4, 5]]
    }
}


class Solution37 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return new ArrayList<List<Integer>>();

    }
}