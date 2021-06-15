import java.util.*;

public class SortedStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(10);
        stack.push(5);
        stack.push(7);
        stack.push(1);
        sort(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void sort(Stack<Integer> stack) {
        Stack<Integer> buffer = new Stack<Integer>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!buffer.isEmpty() && buffer.peek() > temp) {
                stack.push(buffer.pop());
            }
            buffer.push(temp);
        }

        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
    }
}
