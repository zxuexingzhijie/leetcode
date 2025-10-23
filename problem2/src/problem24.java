// LeetCode题目链接: https://leetcode.cn/problems/add-two-numbers/
public class problem24 {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode6 l1 = new ListNode6(2, new ListNode6(4, new ListNode6(3)));
        ListNode6 l2 = new ListNode6(5, new ListNode6(6, new ListNode6(4)));
        ListNode6 result = solution24.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode66 {
 *     int val;
 *     ListNode66 next;
 *     ListNode66() {}
 *     ListNode66(int val) { this.val = val; }
 *     ListNode66(int val, ListNode6 next) { this.val = val; this.next = next; }
 * }
 */
class Solution24 {
    public ListNode6 addTwoNumbers(ListNode6 l1, ListNode6 l2) {
        ListNode6 res = new ListNode6(0, null);
        ListNode6 cur = res;
        int count = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + count;
            if (sum >= 10) {
                count = 1;
                sum = sum - 10;
            } else {
                count = 0;
            }
            cur.next = new ListNode6(sum, null);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            while (l2 != null) {
                int sum = l2.val + count;
                if (sum >= 10) {
                    count = 1;
                    sum -= 10;
                } else {
                    count = 0;
                }
                cur.next = new ListNode6(sum, null);
                cur = cur.next;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                int sum = l1.val + count;
                if (sum >= 10) {
                    count = 1;
                    sum -= 10;
                } else {
                    count = 0;
                }
                cur.next = new ListNode6(sum, null);
                cur = cur.next;
                l1 = l1.next;
            }
        }

        if (count > 0) {
            cur.next = new ListNode6(count, null);
        }

        return res.next;
    }
}


class ListNode6 {
    int val;
    ListNode6 next;
    ListNode6() {}
    ListNode6(int val) { this.val = val; }
    ListNode6(int val, ListNode6 next) { this.val = val; this.next = next; }
}