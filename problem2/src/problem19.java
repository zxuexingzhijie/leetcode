public class problem19 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        ListNode1 listNode1 = new ListNode1(1);
        listNode1.next = new ListNode1(2);
        listNode1.next.next = new ListNode1(3);
        listNode1.next.next.next = new ListNode1(4);
        listNode1.next.next.next.next = new ListNode1(5);
        ListNode1 result = solution19.reverseList(listNode1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution19 {
    public ListNode1 reverseList(ListNode1 head) {
        ListNode1 pre = null;
        ListNode1 curr = head;
        while (curr != null) {
            ListNode1 next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}