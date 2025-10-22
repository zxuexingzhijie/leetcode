import java.util.*;
import java.util.stream.Collectors;

public class problem67 {
    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int res = solution67.findKthLargest(nums, k);
        System.out.println(res);
    }
}

//class Solution67 {
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }
//}

class Solution67 {
    public int findKthLargest(int[] nums, int k) {
        // 小顶堆,自动排序（堆结构）
        //
        //PriorityQueue 默认是小顶堆（即堆顶是最小元素）。
        //
        //每次 add() 插入元素时，会自动调整堆结构，保证堆顶永远是最小值。
        //
        //poll() 删除并返回最小值，peek() 只取最小值不删除。
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最小值
            }
        }

        return heap.peek(); // 堆顶就是第 k 大元素
    }
}