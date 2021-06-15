import java.util.*;

public class QueueViaStacks {
    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
    }
}

public class QueueWithTwoStacks {
    Stack<Integer> stackNewest, stackOldest;

    public QueueWithTwoStacks() {
        this.stackNewest = new Stack<Integer>();
        this.stackOldest = new Stack<Integer>();
    }

    public int size() {
        return stackOldest.size() + stackNewest.size();
    }

    public void enqueue(int value) {
        stackNewest.push(value);
    }

    public void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public int peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public int dequeue() {
        shiftStacks();
        return stackOldest.pop();
    }
}
