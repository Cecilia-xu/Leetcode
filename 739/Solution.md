# My solution
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
2. It is not neccessary to push the value. Since the attribute of array is that we can access any value when we get the index. Therefore, the operation of pushing index is enough. -> Save space of stack
