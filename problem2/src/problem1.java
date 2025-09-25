public class problem1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] list = new int[2];
        for(int i = 0;i<nums.length;i++){
            for (int j = i+1;j<nums.length;j++){
                if (nums[i]+nums[j] == target){
                    list[0] = i;
                    list[1] = j;
                }
            }
        }
        return list;
    }
}