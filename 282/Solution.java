// Solution 1: DFS + String
// Cons: String is immutable so that editting string is very slow.
// Time complexity: O(n! * n). Base case: O(n). For the first level, there might be n choices,. However, for the second level,
// the worst case has 3 * n -1 chocies for just one node.-> O(n! * n)
// Space complexity: O(n) The height of the recursion tree is num.length().
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        dfs(res, "", num, target, 0, 0, 0);
        return res;
    }
    
    private void dfs(List<String> res, String expression, String num, int target, int curIdx, long value, long preNum) {
        // dfs ends
        if (curIdx == num.length()) {
            if (value == target) {
                res.add(expression);
            }
            return;
        }
        
        // recursion
        for (int i = curIdx; i < num.length(); i++) {
            // leading zero -> invalid number 
            // Note: 0 is valid!!!
            if (num.charAt(curIdx) == '0' && i != curIdx) {
                break;
            }
            
            // get num (start from curIdx -> must use every number and keep the original order)
            long n = Long.parseLong(num.substring(curIdx, i + 1));
            
            // recursion rule
            // case 1: if num is the first number(no operators)
            if (curIdx == 0) {
                dfs(res, expression + n, num, target, i + 1, value + n, n);
            }
            // case 2: if num is not the first number (3 operators)
            else {
                dfs(res, expression + "+" + n, num, target, i + 1, value + n, n);
                dfs(res, expression + "-" + n, num, target, i + 1, value - n, -n);
                dfs(res, expression + "*" + n, num, target, i + 1, value - preNum + preNum * n, preNum * n);
            }
        }
        
    }
}

// Solution 2: DFS + Stringbuilder
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        StringBuilder expression = new StringBuilder();
        dfs(res, expression, num, target, 0, 0, 0);
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder expression, String num, int target, int curIdx, long value, long preNum) {
        // dfs ends
        if (curIdx == num.length()) {
            if (value == target) {
                res.add(expression.toString());
            }
            return;
        }
        
        // recursion
        for (int i = curIdx; i < num.length(); i++) {
            // leading zero -> invalid number 
            // Note: 0 is valid!!!
            if (num.charAt(curIdx) == '0' && i != curIdx) {
                break;
            }
            
            // get the orignal length
            int length = expression.length();
            // get num (start from curIdx -> must use every number and keep the original order)
            long n = Long.parseLong(num.substring(curIdx, i + 1));
            
            // recursion rule
            // case 1: if num is the first number(no operators) & backtracking
            if (curIdx == 0) {
                dfs(res, expression.append(n), num, target, i + 1, value + n, n);
                expression.setLength(length);
            }
            // case 2: if num is not the first number (3 operators)
            else {
                dfs(res, expression.append('+').append(n), num, target, i + 1, value + n, n);
                expression.setLength(length);
                
                dfs(res, expression.append('-').append(n), num, target, i + 1, value - n, -n);
                expression.setLength(length);
                
                dfs(res, expression.append('*').append(n), num, target, i + 1, value - preNum + preNum * n, preNum * n);
                expression.setLength(length);
            }
        }
        
    }
}
