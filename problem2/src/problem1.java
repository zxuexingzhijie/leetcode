import java.util.HashMap;

// LeetCode题目链接: https://leetcode.cn/problems/two-sum/
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
        HashMap<Integer, Integer> res = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if (res.containsKey(target-nums[i])){
                return new int[]{res.get(target-nums[i]),i};
            }
            res.put(nums[i],i);
        }
        return null;

    }
}