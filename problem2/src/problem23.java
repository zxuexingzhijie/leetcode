// LeetCode题目链接: https://leetcode.cn/problems/merge-two-sorted-lists/
public class problem23 {
    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        ListNode5 listNode5_1 = new ListNode5(1);
        listNode5_1.next = new ListNode5(2);
        listNode5_1.next.next = new ListNode5(4);
        ListNode5 listNode5_2 = new ListNode5(1);
        listNode5_2.next = new ListNode5(3);
        listNode5_2.next.next = new ListNode5(4);
        ListNode5 ans = solution23.mergeTwoLists(listNode5_1, listNode5_2);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode5 {
 *     int val;
 *     ListNode5 next;
 *     ListNode5() {}
 *     ListNode5(int val) { this.val = val; }
 *     ListNode5(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution23 {
    public ListNode5 mergeTwoLists(ListNode5 list1, ListNode5 list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode5 a = list1;
        ListNode5 b = list2;
        ListNode5 head = new ListNode5(0);
        ListNode5 cur = head;
        while (a != null && b != null) {
            if (a.val == b.val) {
                head.next = a;
                a = a.next;
                head = head.next;
            }else if(a.val > b.val) {
                head.next = b;
                b = b.next;
                head = head.next;
            }else {
                head.next = a;
                a = a.next;
                head = head.next;
            }
        }
        head.next = a == null ? b : a;
        return cur.next;
    }
}

class ListNode5 {
    int val;
    ListNode5 next;
    ListNode5() {}
    ListNode5(int val) { this.val = val; }
    ListNode5(int val, ListNode5 next) { this.val = val; this.next = next; }
}
