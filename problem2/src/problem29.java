import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class problem29 {
    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode sortedHead = solution29.sortList(head);
        while (sortedHead != null) {
            System.out.print(sortedHead.val + " ");
            sortedHead = sortedHead.next;
        }
    }
}

class Solution29 {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        Collections.sort(res);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : res) {
            curr.next = new ListNode(num, null);
            curr = curr.next;
        }
        return dummy.next;
    }
}
