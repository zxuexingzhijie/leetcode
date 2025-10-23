import java.util.ArrayList;
import java.util.List;

public class problem74 {
    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        int numRows = 5;
        List<List<Integer>> res = solution74.generate(numRows);
        res.stream().forEach(System.out::println);
    }
}


class Solution74 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        res.add(List.of(1)); // 第一行固定为 [1]

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = res.get(i - 1);   // 上一行
            List<Integer> row = new ArrayList<>(); // 当前行

            row.add(1); // 每行首元素是 1
            for (int j = 1; j < i; j++) {
                // 中间元素为上一行相邻两个数之和
                row.add(prev.get(j - 1) + prev.get(j));
            }
            row.add(1); // 每行尾元素是 1

            res.add(row);
        }

        return res;
    }
}