// LeetCode题目链接: https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
public class problem62 {
    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        int[] nums1 = {3,4,5,1,2};
        int min = solution62.findMin(nums1);
        System.out.println(min);
    }
}


class Solution62 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // 最小值在右半段
                left = mid + 1;
            } else {
                // 最小值在左半段，包括 mid
                right = mid;
            }
        }

        return nums[left]; // 此时 left == right
    }
}