# My solution
``` Java
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if (stack.peek() == min) {
            stack.pop();
            min = stack.pop();
        }
        else {
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```
### Optimized solution
```Java
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int x) {
       if (x <= min) {
           stack.push(min);
           min = x;
       }
        stack.push(x);
    }
    
    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```
Note: <br>
1. sequence of the statement
- push(): 1)push the last min 2)assign new min
- pop(): 1)pop the top element 2)If it is min,pop the new element and assign it to min
2. In if condition, pop() will be ran first before checking the condition. (Concise!)
