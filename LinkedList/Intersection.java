public class Intersection {

    private static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private static class Result {
        private int length;
        private Node tail;

        Result(int length, Node tail) {
            this.length = length;
            this.tail = tail;
        }
    }

    public static Node isIntersecting(Node list1, Node list2) {
        Result list1_result = getLengthAndTail(list1);
        Result list2_result = getLengthAndTail(list2);

        if (list1_result.tail != list2_result.tail) return null;

        Node longer = list1_result.length < list2_result.length
            ? list2 : list1;
        Node shorter = list1_result.length < list2_result.length
            ? list1 : list2;
        longer = balanceLength(longer, java.lang.Math.abs(
                    list1_result.length - list2_result.length));

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;
    }

    private static Result getLengthAndTail(Node list) {
        Node curr = list;
        int length = 1;
        while (curr.next != null) {
            length++;
            curr = curr.next;
        }
        return new Result(length, curr);
    }

    private static Node balanceLength(Node list, int x) {
        Node curr = list;
        while (x > 0 && curr != null) {
            curr = curr.next;
        }
        return curr;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);

        Node head2 = new Node(1);
        head2.next = new Node(2);

        Node interPoint = new Node(3);
        interPoint.next = new Node(4);

        head1.next.next = interPoint;
        head2.next.next = interPoint;
        
        System.out.println(isIntersecting(head1, head2).data);
    }
}
