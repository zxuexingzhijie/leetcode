// LeetCode题目链接: https://leetcode.cn/problems/find-all-anagrams-in-a-string/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class problem8 {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        String s = "abab";
        String p = "ab";
        List<Integer> result = solution8.findAnagrams(s, p);
        System.out.println(result);
    }
}


class Solution8 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null) {
            return list;
        }
        int n = s.length(), m = p.length();
        if (m > n) {
            return list;
        }

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i <= n - m; i++) {
            String sub = sb.substring(i, i + m);
            if (isAnagram(sub, p)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}

