// LeetCode题目链接: https://leetcode.cn/problems/subarray-sum-equals-k/
public class problem9 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        int[] nums = {1,1,1};
        int k = 2;
        int result = solution9.subarraySum(nums, k);
        System.out.println(result);
    }
}


class Solution9 {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] arr = new int[length + 1];
        arr[0] = 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            arr[i+1] =arr[i] + nums[i];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]-arr[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}