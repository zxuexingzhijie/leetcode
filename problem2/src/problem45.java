import java.util.HashMap;
import java.util.Map;

// LeetCode题目链接: https://leetcode.cn/problems/path-sum-iii/
public class problem45 {
    public static void main(String[] args) {
        // 构造一个简单的二叉树测试
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        Solution45 solution45 = new Solution45();
        System.out.println(solution45.pathSum(root, 8)); // 输出 3
    }
}

class Solution45 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 以 root 为起点的路径数量 + 左子树所有起点 + 右子树所有起点
        return countFrom(root, targetSum)
                + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    // 计算以 node 为起点，向下的连续路径中和等于 sum 的数量
    private int countFrom(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val == sum) {
            res++;
        }
        // 继续向下查找剩余的目标 (sum - node.val)
        res += countFrom(node.left, sum - node.val);
        res += countFrom(node.right, sum - node.val);
        return res;
    }
}

