// LeetCode题目链接: https://leetcode.cn/problems/palindrome-partitioning/
import java.util.ArrayList;
import java.util.List;

public class problem57 {
    public static void main(String[] args) {
        Solution57 solution57 = new Solution57();
        String s = new String("aab");
        List<List<String>> res = solution57.partition(s);
        res.stream().forEach(System.out::println);
    }
}


class Solution57 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        backtrace(res, path, s, 0);
        return res;
    }

    private void backtrace(List<List<String>> res, ArrayList<String> path, String s, int index) {
        // 递归结束条件：已处理到字符串末尾，记录当前路径
        if (index == s.length()) {
            res.add(new ArrayList<>(path)); // 记得拷贝
            return;
        }

        // 从 index 开始尝试所有可能的结束位置 i
        for (int i = index; i < s.length(); i++) {
            String cur = s.substring(index, i + 1);
            if (ismirrored(cur)) {              // 如果是回文
                path.add(cur);                 // 选择
                backtrace(res, path, s, i + 1);// 递归下一个位置
                path.remove(path.size() - 1);  // 撤销选择
            }
        }
    }

    private boolean ismirrored(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
