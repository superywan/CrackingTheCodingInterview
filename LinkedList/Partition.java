public class Partition {
    private static class Node {
        private int data;
        private Node next;

        Node (int data) {
            this.data = data;
        } 
    }

    public static Node partition (Node head, int x) {
        Node before_start = null;
        Node before_end = null;
        Node after_start = null;
        Node after_end = null;

        while (head != null) {
            if (head.data < x) {
                if (before_start == null) {
                    before_start = head;
                    before_end = head;
                } else {
                    before_end.next = head;
                    before_end = head;
                }
            } else {
                if (after_start == null) {
                    after_start = head;
                    after_end = head;
                } else {
                    after_end.next = head;
                    after_end = head;
                }
            }
            head = head.next;
        }
        before_end.next = after_start;
        after_end.next = null;
        return before_start;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(0);
        Node result = partition(head, 2);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }
}
