public class problem10 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = solution10.maxSubArray(nums);
        System.out.println(result);
    }
}

class Solution10 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0;i<nums.length;i++){
            if (sum < 0) {
                sum = 0;
            }
            sum+=nums[i];
            max = Math.max(sum,max);
        }
        return max;
    }
}
