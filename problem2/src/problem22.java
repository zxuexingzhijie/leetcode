public class problem22 {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        ListNode4 listNode4 = new ListNode4(3);
        listNode4.next = new ListNode4(2);
        listNode4.next.next = new ListNode4(0);
        listNode4.next.next.next = new ListNode4(-4);
        listNode4.next.next.next.next = listNode4.next;
        System.out.println(solution22.detectCycle(listNode4));
    }
}


/**
 * Definition for singly-linked list.
 * class ListNode4 {
 *     int val;
 *     ListNode4 next;
 *     ListNode4(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution22 {
    public ListNode4 detectCycle(ListNode4 head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode4 slow = head;
        ListNode4 fast = head;
        // 必须检查 fast 和 fast.next，否则可能空指针异常，不能用slow.next来判断
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode4 ans = head;
                // 相遇点到环入口点距离 = head 到环入口点距离
                //这块原理需要很强的数学功底
                while(ans != slow){
                    ans = ans.next;
                    slow = slow.next;
                }
                return ans;
            }
        }
        // fast 到尾部说明无环
        return null;
    }
}

class ListNode4 {
    int val;
    ListNode4 next;
    ListNode4(int x) {
        val = x;
        next = null;
    }
}