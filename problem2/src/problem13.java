import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class problem13 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int[] nums = {1,2,3,4};
        int[] result = solution13.productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

class Solution13 {
    public int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answers[i] = 1;
        }
        int count = 0;
        while (count < nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (i != count){
                    answers[count] *= nums[i];
                }
            }
            count++;
        }
        return answers;
    }
}