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
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}