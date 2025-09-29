import java.util.*;
import java.util.stream.Collectors;

public class problem6 {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> result = solution6.threeSum(nums);
        System.out.println(result);
    }
}

class Solution6 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        ArrayList<Integer> integers = new ArrayList<>(collect);
        HashSet<List<Integer>> res = new HashSet<>();
        int n1;
        Collections.sort(integers);
        for (int i = 0;i<integers.size()-2;i++){
            n1 = integers.get(i);
            int left = i+1;
            int right = integers.size()-1;
            while (left < right){
                if (n1 + integers.get(left)+integers.get(right) == 0){
                    res.add(Arrays.asList(n1,integers.get(left),integers.get(right)));
                    left++;
                }else if (n1 + integers.get(left)+integers.get(right) > 0){
                    right--;
                }else  {
                    left++;
                }
            }
        }
        ArrayList<List<Integer>> lists = new ArrayList<>(res);
        return  lists;
    }
}