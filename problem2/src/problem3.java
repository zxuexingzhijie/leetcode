// LeetCode题目链接: https://leetcode.cn/problems/longest-consecutive-sequence/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class problem3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int result = solution3.longestConsecutive(nums);
        System.out.println(result);
    }
}

class Solution3 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        for (int num : nums) {
            integerHashSet.add(num);
        }
//        ArrayList<Integer> integers = new ArrayList<>(integerHashSet);,转换为list,排序
//        integers.sort(Integer::compareTo);
        List<Integer> list = integerHashSet.stream().sorted().toList(); //转换为list,排序


        int longestStreak = 1;
        int maxcount = 0;
        for (int j = 0;j<list.size()-1;j++){
            if(list.get(j).equals(list.get(j+1)-1)){
                longestStreak += 1;
            }
            else{
                maxcount = Math.max(longestStreak,maxcount);
                longestStreak = 1;
            }
        }
        return Math.max(longestStreak,maxcount);
    }
}