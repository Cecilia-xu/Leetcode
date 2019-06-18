# My solution1: one stack and one array
> Time complexity for pop(): O(1)<br>Space complexity for pop(): O(1)<br> Time complexity for push(): O(n)<br> Space complexity for push(): O(n)
```Java
class MyQueue {
    
    private Stack<Integer> stack;

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
### Optimized official solution: 2 stacks
> The first official solution is similar to mine. However, it constructs the data structure by using two stacks, which can avoid problems of dealing with indexes.
```Java
class MyQueue {
    
    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.empty()){
            tempStack.push(stack.pop());
        }
        stack.push(x);
        while (!tempStack.empty()){
            stack.push(tempStack.pop());
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
# Solution 2: two stacks
> Time complexity for push(): O(1)<br> Space complexity for push(): O(n)<br> Time complexity for pop(): O(n)<worst case>/ O(1)<amortized><br> Space complexity for pop(): O(1)
```Java
class MyQueue {
    
    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();;

    /** Initialize your data structure here. */
    public MyQueue() {

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty() && output.empty();
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
Note: solution 2 is much more efficient than the first one since we do not need to push back all the elements from the 2nd stack to the 1st stack.
