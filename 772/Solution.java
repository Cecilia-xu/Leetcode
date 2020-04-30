// Solution: Recursion + Stack
// Time complexity: O(n^2). Worst case: brackets
// Space complexity: O(n)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Number
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }
            
            // Bracket(* find the expression from open bracket to its corresponding close bracket)
            if (c == '(') {
                int openCount = 1;
                int j = i + 1;
                while (j < s.length() && openCount > 0) { // do not forget to check j is out of bound or not
                    char next = s.charAt(j);
                    if (next == '(') {
                        openCount++;
                    }
                    if (next == ')') {
                        openCount--;
                    }
                    j++;
                }
                number = calculate(s.substring(i + 1, j)); // how to get the subsdtring
                i = j - 1 // move i
            }
            
            // Operators
            if (c != ' ' && !Character.isDigit(c) || i == s.length() - 1) { //******last number case!!!!
                if (operator == '+') {
                    stack.push(number);
                }
                else if (operator == '-') {
                    stack.push(-number);
                }
                else if (operator == '*') {
                    stack.push(stack.pop() * number);
                }
                else if (operator == '/') {
                    stack.push(stack.pop() / number);
                }
                // ********recover number and reassign operator 
                number = 0;
                operator = c;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}
