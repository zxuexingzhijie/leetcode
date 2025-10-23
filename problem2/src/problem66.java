// LeetCode题目链接: https://leetcode.cn/problems/daily-temperatures/
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class problem66 {
    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = solution66.dailyTemperatures(temperatures);
        Arrays.stream(res).forEach(System.out::println);
    }
}

class Solution66 {
    // 单调栈解法
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> deque = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            //这边为什么要用while循环，因为用 while 是因为当前元素可能会解决栈中多个“未匹配”的元素，
            //必须不断弹出，直到栈恢复单调性。
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                int pop = deque.pop();
                ans[pop] =  i - pop;
            }

            deque.push(i);
        }
        return ans;
    }
}

