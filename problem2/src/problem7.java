// LeetCode题目链接: https://leetcode.cn/problems/longest-substring-without-repeating-characters/
import java.util.Arrays;
import java.util.HashSet;

public class problem7 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        String s = "pwwkew";

        int result = solution7.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}

class Solution7 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        StringBuilder sb = new StringBuilder(s);
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLen = 0;
        int n = sb.length();

        while (right < n) {
            char c = sb.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                right++;
                maxLen = Math.max(maxLen, right - left);
            } else {
                // 遇到重复字符，移动 left 并从集合中移除对应字符
                set.remove(sb.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
}
