import java.util.Arrays;

public class problem44 {
    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode ans = solution44.buildTree(preorder, inorder);
        System.out.println(ans.toString());
    }
}

////这个是最正常的做法
//class Solution44 {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
//    }
//
//    private TreeNode build(int[] preorder, int preStart, int preEnd,
//                           int[] inorder, int inStart, int inEnd) {
//        if (preStart > preEnd || inStart > inEnd) {
//            return null;
//        }
//
//        int rootVal = preorder[preStart];
//        TreeNode root = new TreeNode(rootVal);
//
//        // 在中序数组中找到根节点位置
//        int inRootIndex = inStart;
//        while (inorder[inRootIndex] != rootVal) {
//            inRootIndex++;
//        }
//
//        int leftSize = inRootIndex - inStart;
//
//        // 构建左子树
//        root.left = build(preorder, preStart + 1, preStart + leftSize,
//                inorder, inStart, inRootIndex - 1);
//
//        // 构建右子树
//        root.right = build(preorder, preStart + leftSize + 1, preEnd,
//                inorder, inRootIndex + 1, inEnd);
//
//        return root;
//    }
//}

class Solution44 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int firstnode = preorder[0];
        TreeNode root = new TreeNode(firstnode);


        int index = 0;
        while (inorder[index] != firstnode) {
            index++;
        }


        int[] inleft = Arrays.copyOfRange(inorder,0,index);
        int[] inright = Arrays.copyOfRange(inorder,index+1,inorder.length);

        int inleftlength = inleft.length;

        int[] preleft = Arrays.copyOfRange(preorder,1,inleftlength+1);
        int[] preright = Arrays.copyOfRange(preorder,inleftlength+1,preorder.length);

        root.left = buildTree(preleft,inleft);
        root.right = buildTree(preright,inright);

        return root;

    }
}
