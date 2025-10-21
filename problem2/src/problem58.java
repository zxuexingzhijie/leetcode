public class problem58 {
    public static void main(String[] args) {
        Solution58 solution58 = new Solution58();
        int[] nums = {1,3,5,6};
        int target = 7;
        int i = solution58.searchInsert(nums, target);
        System.out.println(i);
    }
}

class Solution58 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else  {
                right = mid - 1;
            }
        }
        return left;
    }
}
