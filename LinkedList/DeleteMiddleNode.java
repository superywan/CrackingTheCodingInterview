public class DeleteMiddleNode {
    private static class Node {
        private int data;
        private Node next;
        
        Node (int data) {
            this.data = data;
        }
    }

    public static boolean deleteMiddleNode(Node n) {
        // cannot be deleted if Node is the last Node in the list
        if (n == null || n.next == null) return false; 
        // Copy and skip over middle node
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node mid = head.next.next;
        head.next.next.next = new Node(4);
        deleteMiddleNode(mid);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
