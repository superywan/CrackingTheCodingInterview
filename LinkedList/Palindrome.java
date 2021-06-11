public class Palindrome {
    private static class Node {
        private int data;
        private Node next;
        
        Node (int data) {
            this.data = data;
        }
    }

    // Solution 1 : Reversing List and Compare Two List
    public static boolean isPalindrome(Node list) {
        Node reversedList = reverseList(list);
        if (list == null || reversedList == null) return false;
        while (list != null || reversedList != null) {
            if (list.data != reversedList.data) return false;
            list = list.next;
            reversedList = reversedList.next;
        }
        return true;
    }

    public static Node reverseList(Node n) {
        Node head = null;
        while (n != null) {
            Node temp = new Node(n.data);
            temp.next = head; 
            head = temp;
            n = n.next;
        }
        return head;
    }

    //Solution 2 : Using Stack
    public static boolean isPalindromeUsingStack(Node n) {
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        Node slow = n;
        Node fast = n;

        while (fast != null || fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) slow = slow.next;
        while (slow != null) {
            int top = stack.pop();
            if (top != slow.data) return false;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        System.out.println(isPalindrome(head));

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(1);
        System.out.println(isPalindrome(head2));

        Node head3 = new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(3);
        System.out.println(isPalindrome(head3));

        Node head4 = new Node(1);
        head4.next = new Node(2);
        head4.next.next = new Node(1);
        System.out.println(isPalindrome(head4));
    }
}
