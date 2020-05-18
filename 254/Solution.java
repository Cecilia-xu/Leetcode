// Solution 1: DFS(optimal solution)
// Notes: try 2...sqrt(n) in each level. The recursion tree's height is logn. Traversal + Add the result
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 1) {
            return result;
        }
        dfs(result, new ArrayList<Integer>(), n, 2);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> solution, int n, int start) {
        // we did not add factors into solution when n / i is smaller than i, which means when i == n / i we have already added it
        for (int i = start; i <= n / i; i++) {
            // if i is a factor
            if (n % i == 0) {
                // add this node as a solution
                solution.add(i);
                solution.add(n / i);
                result.add(new ArrayList<Integer>(solution));
                // remove the larger one for the further searching
                solution.remove(solution.size() - 1);
                // dfs
                dfs(result,solution, n / i, i);
                // backtracking
                solution.remove(solution.size() - 1);
            }
        }
    }
}

// Solution 2: DFS
// Notes: Try 2 ... n in each level. The recursion tree is also logn. Stop recursion when n / i == 1. Only add leaves.
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 1) {
            return result;
        }
        dfs(result, new ArrayList<Integer>(), n, 2);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> solution, int n, int start) {
        if (n == 1) {
            if (solution.size() != 1) {
                result.add(new ArrayList<Integer>(solution));
            }
            return;
        }
        
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                // i is a factor
                solution.add(i);
                dfs(result, solution, n / i, i);
                // backtrack
                solution.remove(solution.size() - 1);
            }
        } 
    }
}
