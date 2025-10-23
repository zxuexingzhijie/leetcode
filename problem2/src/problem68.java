// LeetCode题目链接: https://leetcode.cn/problems/top-k-frequent-elements/
import java.util.*;

public class problem68 {
    public static void main(String[] args) {
        Solution68 solution68 = new Solution68();
        int[] nums1 = {1,1,1,2,2,3};
        int k1 = 2;
        int[] res = solution68.topKFrequent(nums1, k1);
        Arrays.stream(res).forEach(System.out::println);
    }
}

class Solution68 {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 统计频率（保留你原来的 HashMap 名称 res）
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(nums[i])) {
                res.put(nums[i], res.get(nums[i]) + 1);
            } else {
                res.put(nums[i], 1);
            }
        }

        // 2. 创建小顶堆，但堆中存放的是 key ，比较器根据 res.get(key)（频率）排序
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(res::get));

        // 3. 把每个 key 放入堆，保持堆大小为 k
        for (int key : res.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 4. 从堆中取出 top k 的 key，注意顺序从后向前填充（可保持任意顺序也可反转）
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }

        return result;
    }
}
