// LeetCode题目链接: https://leetcode.cn/problems/swap-nodes-in-pairs/
import java.util.ArrayList;

public class problem26 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solution26.swapPairs(l1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class Solution26 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < res.size() - 1; i += 2) {
            int temp = res.get(i);
            res.set(i, res.get(i + 1));
            res.set(i + 1, temp);
        }
        ListNode realres = new ListNode(0, null);
        ListNode dummy = realres;
        for (int i : res) {
            dummy.next = new ListNode(i, null);
            dummy = dummy.next;
        }
        return realres.next;
    }
}
