public class RemoveDups {

    private static class Node {
        private int data;
        private Node next;

        Node (int data) {
            this.data = data;
        }
    }
    
    public static void removeDupsWithHashSet(Node n) {
        java.util.HashSet<Integer> set = new java.util.HashSet<Integer>();
        Node prev = null;

        while (n != null) {
            if (set.contains(n.data)) {
                prev.next = n.next;
            } else {
                set.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }

    public static void removeDupsWithRunner(Node head) {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node (2);
        head.next.next.next.next = new Node(1);
        removeDupsWithHashSet(head);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
