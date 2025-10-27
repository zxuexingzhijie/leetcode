// LeetCode题目链接: https://leetcode.cn/problems/binary-tree-level-order-traversal/
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
        ArrayList<List<Integer>> res = new ArrayList<>();

        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);

        while(!nodes.isEmpty()) {
            int size = nodes.size();
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                if (node != null) {
                    list.add(node.val);
                }else  {
                    list.add(null);
                }

                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
            res.add(list);
        }

        return res;

    }
}