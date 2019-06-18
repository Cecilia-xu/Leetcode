# My solution: using one stack and one array
```Java
class MyQueue {
    
    private Stack<Integer> stack;
    int top;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        int[] tem = new int[stack.size()];
        int i = -1;
        while (!stack.empty()){
            tem[++ i] = stack.pop();
        }
        stack.push(x);
        for (int j = tem.length - 1; j >= 0; j --) {
            stack.push(tem[j]);
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```
