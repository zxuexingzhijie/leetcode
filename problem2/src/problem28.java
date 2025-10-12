public class problem28 {
    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.next = null;
        node5.random = node1;
        Node result = solution28.copyRandomList(node1);
        while (result != null) {
            System.out.print("Node val: " + result.val);
            if (result.random != null) {
                System.out.print(", Random points to: " + result.random.val);
            } else {
                System.out.print(", Random points to: null");
            }
        }
        System.out.println();
    }
}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution28 {
    public Node copyRandomList(Node head) {


    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
