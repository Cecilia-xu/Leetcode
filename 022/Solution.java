// Solution: DFS
// Time complexity: O(4^n). The recursion tree's height is 2n. For ith, the tree have 2^i nodes.
// Therefore, the number of leaves of the tree is 2^2n = 4^n. Since we visit all nodes in the recursion tree,
// the number of nodes should be: O(1 + 2 + ... + 2 ^2n) -> O(4^n)
// Space complexity: O(2n + k). 2n: the number of call stack, k: the size of result list 
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int leftCount = 0, rightCount = 0;
        findValidPare(result, "", leftCount, rightCount, n);
        return result;
    }
    
    private void findValidPare(List<String> result, String solution, int leftCount, int rightCount, int n) {
        // base case
        if (leftCount + rightCount == 2 * n) {
            result.add(solution);
            return;
        }
        
        // add '('
        if (leftCount < n) {  
            findValidPare(result, solution + '(', leftCount + 1, rightCount, n);
        }
        
        // add ')'
        if (rightCount < leftCount) { 
            findValidPare(result, solution + ')', leftCount, rightCount + 1, n);
        }
    }
} 
