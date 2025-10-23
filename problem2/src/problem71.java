// LeetCode题目链接: https://leetcode.cn/problems/jump-game-ii/
public class problem71 {
    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();
        int[] nums = {2,3,1,1,4};
        int res = solution71.jump(nums);
        System.out.println(res);
    }
}


class Solution71 {
    public int jump(int[] nums) {
        int jumps = 0;       // 跳跃次数
        int end = 0;         // 当前跳跃能到达的边界
        int maxReach = 0;    // 当前范围内能到达的最远位置

        for (int i = 0; i < nums.length - 1; i++) {
            // 更新能到达的最远位置
            maxReach = Math.max(maxReach, i + nums[i]);

            // 到达当前跳跃边界，需要进行下一次跳跃
            if (i == end) {
                jumps++;
                end = maxReach; // 更新下一步的边界
            }
        }

        return jumps;
    }
}