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
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return level;
    }
}

