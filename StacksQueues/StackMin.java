public class StackWithMin {
    public static void main(String[] args) {
        StackWithNodeMin stack1 = new StackWithNodeMin();
        stack1.push(1);
        stack1.push(2);
        System.out.println(stack1.min());
        System.out.println(stack1.pop().value);

        StackWithTwoStack stack2 = new StackWithTwoStack();
        stack2.push(1);
        stack2.push(2);
        stack2.push(0);
        System.out.println(stack2.min());
        System.out.println(stack2.pop());
        System.out.println(stack2.min());
    }
}

// Solution 1 : Stack of Node with min value
public class StackWithNodeMin extends java.util.Stack<NodeWithMin> {
    public void push(int value) {
        int newMin = java.lang.Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) return java.lang.Integer.MAX_VALUE;
        return peek().min;
    }

}

public class NodeWithMin {
    public int value;
    public int min;

    public NodeWithMin(int value, int min) {
        this.value = value;
        this.min = min; 
    }
}

// Solution 2 : Using two stacks
public class StackWithTwoStack extends java.util.Stack<Integer> {
    java.util.Stack<Integer> minStack;
    public StackWithTwoStack() {
        minStack = new java.util.Stack<Integer>();
    }

    public void push(int value) {
        if (value <= min()) minStack.push(value);
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) minStack.pop();
        return value;
    }

    public int min() {
        if (minStack.isEmpty()) return java.lang.Integer.MAX_VALUE;
        else return minStack.peek(); 
    }
}
