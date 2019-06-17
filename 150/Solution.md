# My solution
> Time complexity: O(n) <br> Space complexity: O(n)
```Java
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> numbers = new Stack<>();
        int res = 0;
        for (int i = 0; i < tokens.length; i ++) {
            if (tokens[i].equals("+")) {
                int a = numbers.peek();
                numbers.pop();
                int b = numbers.peek();
                numbers.pop();
                res = b + a;
                numbers.push(res);
            }
            else if (tokens[i].equals("-")) {
                int a = numbers.peek();
                numbers.pop();
                int b = numbers.peek();
                numbers.pop();
                res = b - a;
                numbers.push(res);
            }
            else if (tokens[i].equals("*")) {
                int a = numbers.peek();
                numbers.pop();
                int b = numbers.peek();
                numbers.pop();
                res = b * a;
                numbers.push(res);
            }
            else if (tokens[i].equals("/")) {
                int a = numbers.peek();
                numbers.pop();
                int b = numbers.peek();
                numbers.pop();
                res = b / a;
                numbers.push(res);

            }
            else {
                numbers.push(Integer.parseInt(tokens[i]));
            }
        }
        
        if (!numbers.isEmpty()) return numbers.pop();
        
        return res;
    }
}
```
Note:<br>
1. Double quotation mark " ": string / Single quotation mark: '' char
2. Compare char: == / Compare string: equals()
3. String to Integer: Integer.parseInt()
4. Ask questions:1) divide 0? 2.input one number without any operator?
### Optimized solution
```Java
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> numbers = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
               numbers.push(numbers.pop() + numbers.pop());
            }
            else if (token.equals("-")) {
                int a = numbers.pop();
                int b = numbers.pop();
                numbers.push(b - a);
            }
            else if (token.equals("*")) {
                numbers.push(numbers.pop() * numbers.pop());
            }
            else if (token.equals("/")) {
                int a = numbers.pop();
                int b = numbers.pop();
                numbers.push(b / a);
            }
            else {
                numbers.push(Integer.parseInt(token));
            }
        }
        
        return numbers.pop();
    }
}
```
More concise solution analysis:<br>
1. res variable is useless.
2. pop() can return the number on the top of stack directly, so we can use pop() to get the value and compute them directly.
3. Since we get the current result on the top of the stack, it is not neccessary to return res but just to pop the current result from the stack.
### Another coding style: switch
```Java
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> numbers = new Stack<>();
        for (String token : tokens) {
            switch(token){
                case "+" :  
                    numbers.push(numbers.pop() + numbers.pop());
                    break;
                case "-" :  
                    int a = numbers.pop();
                    int b = numbers.pop();
                    numbers.push(b - a);
                    break;
                case "*" :  
                    numbers.push(numbers.pop() * numbers.pop());
                    break;
                case "/" :  
                    int c = numbers.pop();
                    int d = numbers.pop();
                    numbers.push(d / c);
                    break;
                default:    
                    numbers.push(Integer.parseInt(token));
                }
            }
        
            return numbers.pop();
    }
}
```
