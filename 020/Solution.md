# My Solution
> Time complexity: O(n) <br> Space coplexity: O(n)
``` Java
public class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '['|| s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } 
            else {
                if (stack.size() == 0)  return false;
                if (s.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else if (s.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                else if (s.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }

        }
        return stack.size() == 0 ? true: false;
    }
}
```
Note: <br>
1. Returning the top element in Java is peek()
2. When we want to use stack.peek(), we should make sure the stack is not empty. Use !stack.isEmpty() or stack.size()!=0
3. In the end, we should not return true immediately. Actually, if the stack is not empty at that time, we should return false since there are '(,{,\[' that cannot be matched.
### Optimized Solution
```Java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
```
Note: <br>
1. just need to list 4 different cases
2. Trick: push the closing brackets when checking opening brackets
