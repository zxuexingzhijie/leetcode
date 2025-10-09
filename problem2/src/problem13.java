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
            for (int i = 0; i < nums.length-1; i++) {
                if (i != count){
                    answers[count] *= nums[i+1];
                }
            }
            count++;
        }

        //数组转换为LIST并反转
//        List<Integer> list = Arrays.stream(answers).boxed().toList();
        //Collections.reverse()这里需要可变序列，所以要用ArrayList,不直接转换为List
        List<Integer> list = new ArrayList<>(Arrays.stream(answers).boxed().toList());
        Collections.reverse(list);
        //LIST转换为int数组
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }
}