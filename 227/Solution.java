// Solution: stack
// related problems: No.772 No.224
// Trick: transform the expression to addition problem: +num -> num, -num -> (-1) * num, * / -> push the result
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int calculate(String s) {
        char[] expression = s.toCharArray();
        Stack<Integer> calStack = new Stack<>();
        char op = '+'; //* deal with the first number without any operator before it
        for (int i = 0; i < expression.length; i++) {
            // leading spaces
            if (expression[i] == ' ') {
                continue;
            }
            // find nums
            int num = 0;
            while (i < expression.length && expression[i] >= '0' && expression[i] <= '9') {
                num = num * 10 + expression[i] - '0';
                i++;
            }
            // check the operator before num
            if (op == '+') {
                calStack.push(num);
            }
            else if (op =='-') {
                calStack.push(-1 * num);
            }
            else if (op == '*' ) {
                calStack.push(calStack.pop() * num);
            }
            else if (op == '/') {
                calStack.push(calStack.pop() / num);
            }
            // trailing spaces
            while (i < expression.length && expression[i] == ' ') {
                i++;
            }
            // find the operator after num
            if (i < expression.length) {
                op = expression[i];
            }
        }
        
        // post processing
        int result = 0;
        while (!calStack.isEmpty()) {
            result += calStack.pop();
        }
        return result;
    }
}
