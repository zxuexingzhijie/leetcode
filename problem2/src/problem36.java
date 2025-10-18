public class problem36 {
    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int diameter = solution36.diameterOfBinaryTree(root);
        System.out.println(diameter); // Output: 4
    }
}

class Solution36 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxlength(root);
        return max;
    }

    private int maxlength(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = maxlength(root.left);
        int right = maxlength(root.right);
        max = Math.max(left+right,max);
        return Math.max(left,right)+1;
    }
}