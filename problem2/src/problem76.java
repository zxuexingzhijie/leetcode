// LeetCode题目链接: https://leetcode.cn/problems/perfect-squares/
public class problem76 {
    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        int n = 12;
        int i = solution76.numSquares(n);
        System.out.println(i);  // 输出 3，因为 12 = 4 + 4 + 4
    }
}

class Solution76 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 0; // 0 不需要任何平方数表示

        // 从 1 到 n 逐个计算最优解
        for (int i = 1; i <= n; i++) {
            dp[i] = i;  // 最坏情况：全部由 1 组成 (1+1+1+...+1)
            // 枚举所有平方数
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}

