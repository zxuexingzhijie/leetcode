public class problem40 {
    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        boolean validBST = solution40.isValidBST(root);
        System.out.println(validBST);
    }
}

class Solution40 {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root,null,null);
    }

    private boolean checkBST(TreeNode node, Integer min, Integer max) {
        // 空节点永远合法（递归终止条件）
        if (node == null) {
            return true;
        }

        // 当前节点的值必须大于左边界、小于右边界
        if (min != null && node.val <= min) {
            return false; // 小于或等于左边界，错误
        }
        if (max != null && node.val >= max) {
            return false; // 大于或等于右边界，错误
        }

        // 检查左子树（最大值不能超过当前节点）
        boolean leftIsValid = checkBST(node.left, min, node.val);

        // 检查右子树（最小值不能小于当前节点）
        boolean rightIsValid = checkBST(node.right, node.val, max);

        // 只有左右子树都合法，整棵树才合法
        return leftIsValid && rightIsValid;
    }
}
