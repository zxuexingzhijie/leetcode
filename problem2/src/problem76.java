import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// LeetCode题目链接: https://leetcode.cn/problems/perfect-squares/
public class problem76 {
    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        int n = 12;
        int i = solution76.numSquares(n);
        System.out.println(i);  // 输出 3，因为 12 = 4 + 4 + 4
    }
}

class Solution76 {
    public int numSquares(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(n);
        visited[n] = true;
        int level = 0; // BFS 层数 = 用了多少个平方数

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                // 尝试减去所有平方数
                for (int j = 1; j * j <= cur; j++) {
                    int next = cur - j * j;
                    if (next == 0) {
                        return level; // 正好到达0，返回层数
                    }
                    if (!visited[next]) {   // 如果没访问过
                        visited[next] = true;  // 标记为已访问
                        queue.offer(next);     // 放入队列
                    }
                }
            }
        }
        return level;
    }
}

//还有种数学解法
//class Solution76 {
//    public int numSquares(int n) {
//        if (isSquare(n)) return 1;
//
//        // 判断是否是两个平方数之和
//        for (int i = 1; i * i <= n; i++) {
//            if (isSquare(n - i * i)) return 2;
//        }
//
//        // 去掉4的因子
//        while (n % 4 == 0) n /= 4;
//        if (n % 8 == 7) return 4;
//
//        return 3;
//    }
//
//    private boolean isSquare(int x) {
//        int r = (int)Math.sqrt(x);
//        return r * r == x;
//    }
//}
