// LeetCode题目链接: https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class problem41 {
    public static void main(String[] args) {
        Solution41 solution41 = new Solution41();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        int i = solution41.kthSmallest(root, 3);
        System.out.println(i);
    }
}


class Solution41 {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        foreach(root, res);
        Collections.sort(res);
        return res.get(k-1);
    }

    private void foreach(TreeNode root, ArrayList<Integer> res){
        if (root == null){
            return;
        }
        res.add(root.val);
        foreach(root.left,res);
        foreach(root.right,res);
    }
}