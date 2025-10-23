// LeetCode题目链接: https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class problem53 {
    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();

        String digits = "23";
        List<String> res = solution53.letterCombinations(digits);
        res.stream().forEach(System.out::println);
    }
}

class Solution53 {
    public List<String> letterCombinations(String digits) {
        HashMap<String, String> nums = new HashMap<>();
        nums.put("1", null);
        nums.put("2", "abc");
        nums.put("3", "def");
        nums.put("4", "ghi");
        nums.put("5", "jkl");
        nums.put("6", "mno");
        nums.put("7", "pqrs");
        nums.put("8", "tuv");
        nums.put("9", "wxyz");

        ArrayList<String> res = new ArrayList<>();

        StringBuilder path = new StringBuilder();

        backtrack(nums,digits,0,path,res);
        return res;
    }

    private void backtrack(HashMap<String, String> nums, String digits, int index,StringBuilder path, ArrayList<String> res) {

        if (index == digits.length()){
            res.add(path.toString());
            return;
        }

        //String.valueOf方法将其余数据类型转为String
        String c = String.valueOf(digits.charAt(index));

        String letter = nums.get(c);

        if (letter == null){
            backtrack(nums,digits,index+1,path,res);
        }

        for(int i = 0;i<letter.length();i++){
            path.append(letter.charAt(i));
            backtrack(nums,digits,index+1,path,res);
            path.deleteCharAt(path.length()-1);
        }


    }
}
