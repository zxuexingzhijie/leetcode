import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class problem38 {
    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> levels = solution38.levelOrder(root);
        System.out.println(levels); // Output: [[1], [2, 3], [4, 5]]
    }
}

class Solution38 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> res = new LinkedList<>();
        res.offer(root);

        while (!res.isEmpty()){
            int size = res.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0;i<size;i++){
                TreeNode node = res.poll();
                level.add(node.val);
                if (node.left != null){
                    res.offer(node.left);
                }
                if (node.right != null){
                    res.offer(node.right);
                }
            }
            lists.add(level);
        }
        return lists;
    }
}
