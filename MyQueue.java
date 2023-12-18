import java.util.*;

class MyQueue {
    private Stack stack1;
    private Stack stack2;

    // constructor to initialize two stacks
    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(x);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.top();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}