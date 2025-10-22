import java.util.*;

public class problem72 {
    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
        String s = new String("ababcbacadefegdehijhklij");
        List<Integer> res = solution72.partitionLabels(s);
        res.stream().forEach(System.out::println);
    }
}

class Solution72 {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> start = new HashMap<>();
        Map<Character, Integer> end = new HashMap<>();

        // 记录起始和结束位置
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            start.putIfAbsent(c, i); // 第一次出现的位置
            end.put(c, i);           // 不断更新最后出现位置
        }

        // 构造区间列表
        List<int[]> intervals = new ArrayList<>();
        for (char c : start.keySet()) {
            intervals.add(new int[]{start.get(c), end.get(c)});
        }

        // 按起始位置排序
        intervals.sort(Comparator.comparingInt(a -> a[0]));

        // 合并区间
        List<int[]> merged = new ArrayList<>();
        int[] cur = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            int[] next = intervals.get(i);
            if (next[0] <= cur[1]) {
                // 重叠，合并区间
                cur[1] = Math.max(cur[1], next[1]);
            } else {
                // 不重叠，保存当前区间并开始新的一段
                merged.add(cur);
                cur = next;
            }
        }
        merged.add(cur);

        // 计算每个区间长度
        List<Integer> res = new ArrayList<>();
        for (int[] p : merged) {
            res.add(p[1] - p[0] + 1);
        }

        return res;
    }
}