import java.util.Arrays;

public class problem79 {
    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        int[] nums = {10,9,2,5,3,7,101,18};
        int i = solution79.lengthOfLIS(nums);
        System.out.println(i);
    }
}


class Solution79 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] = 以 nums[i] 结尾的最长递增子序列长度
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

