public class KthToLast {

    private static class Node {
        private int value;
        private Node next;

        Node (int value) {
            this.value = value;
        }
    } 

    public static Node kthToLast(Node head, int k) {
        Node trav = head;
        Node follower = head;

        // Move trav k nodes apart from follower
        for (int i = 0; i < k; i++) {
            if (trav == null) return null;
            trav = trav.next;
        }

        // Move them at the same pace
        // When trav hits the end, follower will be at kth to last
        while (trav.next != null) {
            trav = trav.next;
            follower = follower.next;
        }
        return follower;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println(kthToLast(head, 2).value);
    }
}
