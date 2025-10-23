// LeetCode题目链接: https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class problem42 {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        List<Integer> res = solution42.rightSideView(root);
        res.stream().forEach(System.out::println);
    }
}

class Solution42 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);

        while (!treeNodes.isEmpty()){
            int size = treeNodes.size();
            for (int i = 0; i < size; i++){
                TreeNode node = treeNodes.poll();
                if (i == size - 1){
                    res.add(node.val);
                }
                if (node.left != null){treeNodes.offer(node.left);}
                if (node.right != null){treeNodes.offer(node.right);}
            }
        }
        return res;
    }
}
