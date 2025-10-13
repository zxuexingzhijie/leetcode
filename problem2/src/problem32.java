import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem32 {
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = solution32.inorderTraversal(root);
        System.out.println(result); // Output: [1, 3, 2]
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution32 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        midsort(root, res);
        return res;
    }

    private void midsort(TreeNode root, ArrayList<Integer> res){
        if (root == null){
            return;
        }
        midsort(root.left,res);
        res.add(root.val);
        midsort(root.right,res);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}