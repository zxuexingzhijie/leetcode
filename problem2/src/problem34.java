public class problem34 {
    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode invertedRoot = solution34.invertTree(root);
        System.out.println(invertedRoot.val); // 4
        System.out.println(invertedRoot.left.val); // 7
        System.out.println(invertedRoot.right.val); // 2
        System.out.println(invertedRoot.left.left.val); // 9
        System.out.println(invertedRoot.left.right.val); // 6
        System.out.println(invertedRoot.right.left.val); // 3
        System.out.println(invertedRoot.right.right.val); // 1
    }
}


class Solution34 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;
        return root;
    }
}