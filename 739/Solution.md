# My solution 1: stack
> Time complexity: O(n)<br> Space complexity:O(n)
```Java
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int res[] = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i ++) {
            while (!stack.isEmpty() && stack.peek() < T[i]){
                    stack.pop();
                    int index = stack.pop();
                    res[index] = i - index;
            }
            stack.push(i);
            stack.push(T[i]);
        }
        
        return res;    
    }
}
```
### Optimized solution
```Java
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int res[] = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i ++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]){
                    int index = stack.pop();
                    res[index] = i - index;
            }
            stack.push(i);
        }
        
        return res;    
    }
}
```
Note:<br>
1. Default values in an int[] array are 0!!! <br> But you need to initialize the array in this way:  int res[] = new int\[T.length(a specific value)\];
2. It is not neccessary to push the value. Since the attribute of array is that we can access any value when we get the index. Therefore, the operation of pushing index is enough. -> Save the space and run-time of the stack
# Solution 2: array
> Time complexity:O(n) <br> Space complexity: O(n)
```Java
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int res[] = new int[T.length];
        int next[] = new int[T.length];
        int top = -1;
        for (int i = 0; i < T.length; i ++) {
            while (top >= 0 && T[next[top]] < T[i]){
                res[next[top]] = i - next[top];
                top --;
            }
            next[++ top] = i;
        }
        
        return res;    
    }
}
```
Note:<br>
1. Since the implementation in stack is dynamic array, we can also use array/dynamic array in this question. Just use a pointer top to simulate peek() in stack.
2.注意 ++/ --的位置！！！
