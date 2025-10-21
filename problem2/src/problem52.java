import java.util.ArrayList;
import java.util.List;

public class problem52 {
    public static void main(String[] args) {
        Solution52 solution52 = new Solution52();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = solution52.subsets(nums);
        res.stream().forEach(System.out::println);
    }
}


class Solution52 {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        backtrack(0,res,nums,temp);
        return (List)res;
    }

    private void backtrack(int i, ArrayList<ArrayList<Integer>> res, int[] nums, ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));

        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            backtrack(j+1,res,nums,temp);
            temp.remove(temp.size()-1);
        }
    }
}