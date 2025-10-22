public class problem70 {
    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        int[] nums = {2,3,1,1,4};
        boolean res = solution70.canJump(nums);
        System.out.println(res);
    }
}

class Solution70 {
    public boolean canJump(int[] nums) {
        int maxreach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxreach) {
                return false;
            }
            maxreach = Math.max(maxreach,i+nums[i]);
            if (maxreach >= nums.length-1) {
                return true;
            }
        }

        return false;
    }
}
