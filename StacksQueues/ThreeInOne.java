public class ThreeInOne {
    public static void main(String[] args) {
        FixedMultiStack stack = new FixedMultiStack(3);
        stack.push(0, 1);
        System.out.println(stack.peek(0));
        stack.push(1, 3);
        System.out.println(stack.peek(0));
        System.out.println(stack.peek(1));
    }
}

public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) return; 
        sizes[stackNum]++;
        values[indexOftop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) return -1;
        int topIndex = indexOftop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) throw new java.util.EmptyStackException();
        return values[indexOftop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOftop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}

