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
