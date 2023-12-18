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

/*
 
class MyQueue {

    Stack<Integer>in;
    Stack<Integer>out;
    public MyQueue() {
        in=new Stack<>();
        out=new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek();
        int val=out.pop();
        return val;
    }
    
    public int peek() {
        if(!out.isEmpty())
        {
            return out.peek();
        }
        else
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
            return out.peek();
        }

    }
    
    public boolean empty() {
        return in.size()==0 && out.size()==0;
        
    }
}
*/

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

