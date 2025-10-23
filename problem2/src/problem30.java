// LeetCode题目链接: https://leetcode.cn/problems/merge-k-sorted-lists/
public class problem30 {
    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        ListNode mergedHead = solution30.mergeKLists(lists);
        while (mergedHead != null) {
            System.out.print(mergedHead.val + " ");
            mergedHead = mergedHead.next;
        }
    }
}

class Solution30 {
    public ListNode mergeKLists(ListNode[] lists) {
        return lists[0];
    }
}