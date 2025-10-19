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
        while (root != null){
            TreeNode p = root.left;
            if (p != null){
                while (p.right != null){
                    p= p.right;
                }
                p.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
