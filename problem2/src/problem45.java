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
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1); // 空路径的前缀和为 0
        return dfs(root, 0L, targetSum, prefixSum);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefixSum) {
        if (node == null) return 0;

        currSum += node.val;
        int count = prefixSum.getOrDefault(currSum - targetSum, 0);

        // 更新当前路径的前缀和出现次数
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        // 递归搜索左右子树
        count += dfs(node.left, currSum, targetSum, prefixSum);
        count += dfs(node.right, currSum, targetSum, prefixSum);

        // 回溯，移除当前节点对应的前缀和（防止影响其他路径）
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);

        return count;
    }
}

