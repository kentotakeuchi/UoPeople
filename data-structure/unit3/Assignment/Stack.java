import jeliot.io.*;

public class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    // Constructor
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
            System.out.println("Pushed " + value + " to the stack");
        } else {
            System.out.println("Stack is full. Cannot push " + value);
        }
    }

    public void pop() {
        if (!isEmpty()) {
            System.out.println("Popped " + stackArray[top--] + " from the stack");
        } else {
            System.out.println("Stack is already empty.");
        }
    }

    // Check if stackArray is empty or not
    public boolean isEmpty() {
        return (top == -1);
    }
}

// Main driver
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(3);

        // Push 3 items to the stack
        stack.push(2);
        stack.push(1);
        stack.push(0);

        // Pop items from the stack at each station
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
