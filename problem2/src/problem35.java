public class problem35 {
    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(solution35.isSymmetric(root));
    }
}

class Solution35 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        //如果两个节点都为空，说明在这个位置上结构对称（空对空）。
        //比如叶子节点的左右子节点都是 null，那这一层自然对称。
        //
        //👉 不能省略的原因：
        //递归到叶子时一定会遇到空指针，若不处理，程序会在下一步访问 t1.val 报错。
        if (t1 == null && t2 == null) {
            return true;
        }


//        如果只有一个为空、另一个不为空，那结构上已经不对称了。这个必须在第一个判断之后进行二次判断
        if (t1 == null || t2 == null) {
            return false;
        }

        //如果两个节点的值不相等，说明在这个位置上数值不对称。
        if (t1.val != t2.val) {
            return false;
        }

        return isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
}
