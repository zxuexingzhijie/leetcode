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
        Arrays.sort(nums);
        int right = nums.length - 1;
        int temp;
        int count = 0;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0){
                temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
                count++;
            }
        }
        for (int i = 0; i <= count; i++) {
            for (int j = i+1; j <= count; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}