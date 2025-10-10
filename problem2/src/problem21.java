public class problem21 {
    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        ListNode3 listNode3 = new ListNode3(3);
        listNode3.next = new ListNode3(2);
        listNode3.next.next = new ListNode3(0);
        listNode3.next.next.next = new ListNode3(-4);
        listNode3.next.next.next.next = listNode3.next;
        System.out.println(solution21.hasCycle(listNode3));
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode3 {
 *     int val;
 *     ListNode3 next;
 *     ListNode3(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution21 {
    public boolean hasCycle(ListNode3 head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode3 slow = head;
        ListNode3 fast = head;
//        while(slow.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if (fast == slow){
//                return true;
//            }
//        }
        while (fast != null && fast.next != null) { // ✅ 必须检查 fast 和 fast.next
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false; // fast 到尾部说明无环
    }
}

class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3(int x) {
        val = x;
        next = null;
    }
}

