
import java.util.Stack;
class MinStack {

    Stack<Integer>minst;
    Stack<Integer>st;
    int min;
    public MinStack() {
        minst=new Stack<>();
        st=new Stack<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        st.push(val);
        min=Math.min(min,val);
        minst.push(min);
        
    }
    
    public void pop() {
        st.pop();
        minst.pop();
        if(!minst.isEmpty())
        {
        min=minst.peek();

        }
        else
        {
            min=Integer.MAX_VALUE;
        }
       
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {

       return minst.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */



 /*
  *
  
  ################## USING PAIR CLASS IN MINSTACK TO SOLVE THE PROBLEM #################

  class MinStack {
    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min = st.isEmpty() ? val : Math.min(val, st.peek().min);
        st.push(new Pair(val, min));
    }
    
    public void pop() {
        if (!st.isEmpty()) {
            st.pop();
        }
    }
    
    public int top() {
        return st.isEmpty() ? Integer.MIN_VALUE : st.peek().value;
    }
    
    public int getMin() {
        return st.isEmpty() ? Integer.MIN_VALUE : st.peek().min;
    }
}

class Pair {
    int value;
    int min;
    public Pair(int value, int min) {
        this.value = value;
        this.min = min;
    }
}

  */