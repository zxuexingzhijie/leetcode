// LeetCode题目链接: https://leetcode.cn/problems/intersection-of-two-linked-lists/
public class problem18 {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);
        headA.next.next = intersection;
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;
        ListNode result = solution18.getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection");
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution18 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
//            pA = pA == null ? headB : pA.next;
//            pB = pB == null ? headA : pB.next;
            if (pA == null){
                pA = headB;
            }else {
                pA =pA.next;
            }
            if (pB == null) {
                pB = headA;
            }else  {
                pB =pB.next;
            }
        }
        return pA;
    }
}

class ListNode {
     int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}