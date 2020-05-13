// Solution: Stack
// Time complexity: O(n). n = nums.length()
// Space complexity: O(n).
class Solution {
    public String removeKdigits(String num, int k) {
        // remove all digits
        if (num.length() == k) {
            return "0";
        }
        
        // find a smaller number for the right most digit until running out of k
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            int n = c - '0';
            while (!stack.isEmpty() && n < stack.peek() - '0' && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // check whether we have running our of all ks
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // build the result in a reversed order
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        
        // remove leading zeros
        int i = res.length() - 1;
        while (res.length() > 1 && res.charAt(i) == '0') {
            res.deleteCharAt(i);
            i--;
        } 
        return res.reverse().toString();
        
    }
}
