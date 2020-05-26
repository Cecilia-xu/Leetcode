// Solution: DFS 
// Time complextiy: O(2^n). For this recursion tree, we have n layers. For each layer, we check wether we remove this char or
// not. Therefore, there are only 2 different options in each layer. -> Time complexity: O(2^n)
// Space complexity: O(n). The height of recursion tree is n,therefore the number of call stacks is n.
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> result = new HashSet<>();
        char[] letters = s.toCharArray();
        int extraLeft = 0, extraRight = 0;
        // find the misplaced "("
        for (int i = 0; i < letters.length; i++) {
            char c = letters[i];
            if (c == '(') {
                extraLeft++;
            }
            else if (extraLeft > 0 && c == ')') {
                extraLeft--;
            }
        }
        // find the misplaced ")"
        for (int i = letters.length - 1; i >= 0; i--) {
            char c = letters[i];
            if (c == ')') {
                extraRight++;
            }
            else if (extraRight > 0 && c == '(') {
                extraRight--;
            }
        }
        
        // try all possible cases and check
        StringBuilder solution = new StringBuilder();
        dfs(result, solution, letters, 0, 0, extraLeft, extraRight);
        
        // return the final answer
        ArrayList<String> output = new ArrayList<>();
        output.addAll(result);
        return output;
    }
    
    private void dfs(HashSet<String> result, StringBuilder solution, char[] letters, int start, int left, int extraLeft, int extraRight) {
        // base case: search until the end
        if (start == letters.length) {
            if (extraLeft == 0 && extraRight == 0) {
                result.add(solution.toString());
            }
            return;
        }
        // remove too many '('
        if (extraLeft < 0) {
            return;
        }
        // remove too many ')'
        if (extraRight < 0) {
            return;
        }      
        
        char c = letters[start];
        // cannot remove a letter (only 1 case)
        if (Character.isLetter(c)) {
            solution.append(c);
            dfs(result, solution, letters, start + 1, left, extraLeft, extraRight);
            // backtracking
            solution.deleteCharAt(solution.length() - 1);
        }
        // letters[start] is a bracket
        else if (c == '(') {
            // case 1: remove
            dfs(result, solution, letters, start + 1, left, extraLeft - 1, extraRight);
            // case 2: add
            solution.append(c);
            dfs(result, solution, letters, start + 1, left + 1, extraLeft, extraRight);
            // backtracking
            solution.deleteCharAt(solution.length() - 1);
        }
        else if (c == ')') {
            // case 1: remove
            dfs(result, solution, letters, start + 1, left, extraLeft, extraRight - 1);
            // case 2: add
            if (left > 0) {
                solution.append(c);
                dfs(result, solution, letters, start + 1, left - 1, extraLeft, extraRight);
                // backtracking
                solution.deleteCharAt(solution.length() - 1);
            }
        }
    }
}
