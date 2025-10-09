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

//class Solution13 {
//    public int[] productExceptSelf(int[] nums) {
//        int[] answers = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            answers[i] = 1;
//        }
//        int count = 0;
//        while (count < nums.length) {
//            for (int i = 0; i < nums.length; i++) {
//                if (i != count){
//                    answers[count] *= nums[i];
//                }
//            }
//            count++;
//        }
//        return answers;
//    }
//}

// Optimized solution without using division and in O(n) time complexity
class Solution13 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];

        L[0]=1;
        R[n-1]=1;

        for(int i=1;i<n;i++){
            L[i]=L[i-1]*nums[i-1];
            R[n-i-1]=R[n-i]*nums[n-i];
        }

        for(int i=0;i<n;i++){
            L[i]=L[i]*R[i];
        }

        return L;
    }
}