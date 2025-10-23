// LeetCode题目链接: https://leetcode.cn/problems/valid-parentheses/
import java.util.Stack;

public class problem63 {
    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        boolean valid = solution63.isValid("()[]{}");
        System.out.println(valid);
    }
}


class Solution63 {
    public boolean isValid(String s) {
        Stack<Character> res = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ||  s.charAt(i) == '[' || s.charAt(i) == '{') {
                res.push(s.charAt(i));
            }else if (res.isEmpty()){
                return false;
            }
            else if (s.charAt(i) == ')' && res.pop() != '(') {
                return false;
            }else if (s.charAt(i) == ']' && res.pop() != '[') {
                return false;
            }else if (s.charAt(i) == '}' && res.pop() != '{') {
                return false;
            }
        }
        return res.isEmpty();
    }
}