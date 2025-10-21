import java.util.ArrayList;
import java.util.List;

public class problem51 {
    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        List<List<Integer>> permute = solution51.permute(new int[]{1, 2, 3});
        permute.stream().forEach(System.out::println);
    }
}

class Solution51 {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        buildmutisort(res,list,nums,used);
        return res;
    }

    private void buildmutisort(ArrayList<List<Integer>> res, ArrayList<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if (used[i]){
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            buildmutisort(res,list,nums,used);
            list.remove(list.size()-1);
            used[i] = false;
        }

    }
}
