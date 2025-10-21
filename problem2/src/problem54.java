import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem54 {
    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        int target = 7;
        int[] ints = {2, 3, 6, 7};
        List<List<Integer>> res = solution54.combinationSum(ints, target);
        res.stream().forEach(System.out::println);
    }
}


class Solution54 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        backtrace(res,path,candidates,target,0);
        return res;
    }

    private void backtrace(List<List<Integer>> res, ArrayList<Integer> path, int[] candidates, int target, int index) {
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index;i<candidates.length;i++){
            if (candidates[i] > target){
                break;
            }
            path.add(candidates[i]);
            backtrace(res,path,candidates,target-candidates[i],i);
            path.remove(path.size()-1);
        }
    }
}
