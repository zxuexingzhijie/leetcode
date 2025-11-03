// LeetCode题目链接: https://leetcode.cn/problems/coin-change/
import java.util.*;

public class problem77 {
    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int res = solution77.coinChange(coins, amount);
        System.out.println(res);  // 输出 3，因为 11 = 5 + 5 + 1
    }
}

class Solution77 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];

        queue.offer(0);      // 从 0 元开始
        visited[0] = true;

        int level = 0;       // BFS 层数 = 使用硬币数

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                for (int coin : coins) {
                    int next = cur + coin;

                    // 如果正好凑到目标金额
                    if (next == amount) {
                        return level;
                    }

                    // 如果没超出范围且没访问过
                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        // 如果 BFS 全部扩展完都没到达 amount，说明无解
        return -1;
    }
}
