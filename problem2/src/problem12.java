// LeetCode题目链接: https://leetcode.cn/problems/rotate-array/
public class problem12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        solution12.rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

class Solution12 {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        k = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(i + k < nums.length) {
                arr[i + k] = nums[i];
            } else {
                arr[k-nums.length+i] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }
}
