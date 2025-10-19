public class problem39 {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        int[] ints = {-10, -3, 0, 5, 9};
        TreeNode res = solution39.sortedArrayToBST(ints);
        printtree(res);
    }


    public static void printtree(TreeNode root){
        if (root == null) {
            return;
        }
        printtree(root.left);
        System.out.print(root.val + " ");
        printtree(root.right);
    }
}


class Solution39 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return null;
        }
        TreeNode res = buildTree(nums, 0, length - 1);
        return res;
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end){
            return null;
        }
        int mid = (start + end) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }
}


