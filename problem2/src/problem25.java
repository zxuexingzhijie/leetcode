// LeetCode题目链接: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
import java.util.ArrayList;

public class problem25 {
    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode result = solution25.removeNthFromEnd(l1, n);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}


class Solution25 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        res.remove(res.size() - n);
        ListNode newHead = new ListNode(0, null);
        ListNode dummy = newHead;
        for (int i : res) {
            dummy.next =  new ListNode(i, null);
            dummy = dummy.next;
        }
        return newHead.next;
    }
}