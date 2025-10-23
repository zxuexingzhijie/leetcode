// LeetCode题目链接: https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
import java.util.Arrays;

public class problem60 {
    public static void main(String[] args) {
        Solution60 solution60 = new Solution60();
        int[] nums={5,7,7,8,8,10};
        int target=8;
        int[] res = solution60.searchRange(nums, target);
        Arrays.stream(res).forEach(System.out::println);
    }
}


class Solution60 {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        if (left == -1) return new int[]{-1, -1}; // 没找到直接返回
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    // 找第一个等于 target 的下标（左边界）
    private int findLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                ans = mid;
                r = mid - 1; // 继续往左找
            }
        }
        return ans;
    }

    // 找最后一个等于 target 的下标（右边界）
    private int findRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1; // 继续往右找
            }
        }
        return ans;
    }
}
