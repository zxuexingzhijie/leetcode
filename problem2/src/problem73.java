// LeetCode题目链接: https://leetcode.cn/problems/climbing-stairs/
public class problem73 {
    public static void main(String[] args) {
        Solution73 solution73 = new Solution73();
        int n = 3;
        int res = solution73.climbStairs(n);
        System.out.println(res);
    }
}

class Solution73 {
    public int climbStairs(int n) {
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}