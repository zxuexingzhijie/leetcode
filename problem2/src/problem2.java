// LeetCode题目链接: https://leetcode.cn/problems/group-anagrams/
import java.util.*;
import java.util.stream.Collectors;

public class problem2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
}


class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            map.computeIfAbsent(new String(charArray),k ->new ArrayList<>()).add(str);
        }
        for (String key: map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}