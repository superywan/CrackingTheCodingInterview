public class Collided {
    private static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node findCollidedPoint(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        
        Node collidPoint = new Node(4);
        collidPoint.next = new Node(5);
        collidPoint.next.next = new Node(6);
        collidPoint.next.next.next = new Node(7);
        collidPoint.next.next.next.next = collidPoint;
        head.next.next.next = collidPoint;

        System.out.println(findCollidedPoint(head).data);
    }
}
