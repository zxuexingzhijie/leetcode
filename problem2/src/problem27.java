import java.util.ArrayList;

public class problem27 {
    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 3;
        ListNode result = solution27.reverseKGroup(l1, k);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class Solution27 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        //res.size()-k是为了防止越界发生
        for (int i = 0; i <= res.size(); i += k) {
            if (i + k - 1 >= res.size()) {
                break;
            }
            int left = i;
            int right = i+k-1;
            while (left<right){
                int temp = res.get(left);
                res.set(left,res.get(right));
                res.set(right,temp);
                left++;
                right--;
            }
        }
        ListNode realres = new ListNode(0, null);
        ListNode dummy = realres;
        for (int i : res) {
            dummy.next = new ListNode(i, null);
            dummy = dummy.next;
        }
        return realres.next;
    }
}
