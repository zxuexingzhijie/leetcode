// LeetCode题目链接: https://leetcode.cn/problems/merge-intervals/
import java.util.Arrays;
import java.util.Comparator;

public class problem11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = solution11.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.print("[" + result[i][0] + "," + result[i][1] + "] ");
        }
    }
}


class Solution11 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        int length = intervals.length;
        int[][] result = new int[length][2];

        // 按起点排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int count = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < length; i++) {
            if (end >= intervals[i][0]) {
                // 有重叠 → 合并
                end = Math.max(end, intervals[i][1]);
            } else {
                // 无重叠 → 保存当前区间
                result[count][0] = start;
                result[count][1] = end;
                count++;

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // 添加最后一个区间
        result[count][0] = start;
        result[count][1] = end;
        count++;

        // 返回有效部分
        return Arrays.copyOf(result, count);
    }
}
