// LeetCode题目链接: https://leetcode.cn/problems/palindrome-linked-list/
import java.util.ArrayList;

public class problem20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        ListNode2 node1 = new ListNode2(1);
        ListNode2 node2 = new ListNode2(2);
        ListNode2 node3 = new ListNode2(2);
        ListNode2 node4 = new ListNode2(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(solution20.isPalindrome(node1));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode2 {
 *     int val;
 *     ListNode2 next;
 *     ListNode2() {}
 *     ListNode2(int val) { this.val = val; }
 *     ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
 * }
 */
class Solution20 {
    public boolean isPalindrome(ListNode2 head) {
        ArrayList<Integer> integers = new ArrayList<>();
        while(head != null){
            integers.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = integers.size()-1;
        while(left<=right){
            if(integers.get(left).equals(integers.get(right))){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
}

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}