public class SumLists {
    private static class Node {
        private int data;
        private Node next;
        
        Node (int data) {
            this.data = data;
        }
    }

    public static Node sumLists(Node list1, Node list2) {
        Node result = new Node(0);
        Node head = result;
        int carryOver = 0;
        while (list1 != null || list2 != null) {
            int i = (list1.data + list2.data + carryOver) % 10;
            int a = (list1.data + list2.data + carryOver) / 10;

            carryOver = a;
            
            result.next = new Node(i);
            result = result.next;

            list1 = list1.next;
            list2 = list2.next;
        }

        if (carryOver > 0) result.next = new Node(1);
        return head.next;
    }

    public static void main(String[] args) {
        Node list1 = new Node(0);
        list1.next = new Node(0);
        list1.next.next = new Node(9);

        Node list2 = new Node(0);
        list2.next = new Node(0);
        list2.next.next = new Node(9);

        Node result = sumLists(list1, list2);
        while(result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }
}
