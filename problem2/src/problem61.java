// LeetCode题目链接: https://leetcode.cn/problems/search-in-rotated-sorted-array/
public class problem61 {
    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int search = solution61.search(nums, target);
        System.out.println(search);
    }
}

class Solution61 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 如果左半段有序
            if (nums[left] <= nums[mid]) {
                // target 在左半段
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右半段必定有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
