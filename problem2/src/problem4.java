// LeetCode题目链接: https://leetcode.cn/problems/move-zeroes/
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class problem4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums = {0,1,0,3,12};
        solution4.moveZeroes(nums);
        System.out.println("[" + String.join(", ", java.util.Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new)) + "]");

    }
}

class Solution4 {
    public void moveZeroes(int[] nums) {
        int left = 0; // 指向下一个要放非零元素的位置
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                // 交换非零元素到前面
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}
