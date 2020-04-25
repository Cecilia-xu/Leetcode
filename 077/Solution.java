// Solution1: DFS (not the optimal solution)
// Notes: n layers. For each layer, we decide add an element or not in a combination. (similar to subset)
// Time complexity: O(k * 2^n). We visited 2^n of all nodes in the recursion tree and copy each solution(length = k)to the result.
// Space complexity: O(C(n,k) + n). The number of call stacks: n + Create a list of results: C(n, k) possible solutions. The size of result is C(n, k)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k > n) {
            return result;
        }
        findCombination(n, k, 1, result, new ArrayList<Integer>());
        return result;
    }
    
    private void findCombination(int n, int k, int num, List<List<Integer>> result, List<Integer> comb) {
        // base case
        if (comb.size() == k) {
            result.add(new ArrayList<Integer>(comb));
            return;
        }
        if (num == n + 1) {
            return;
        }
                
        // add
        if (comb.size() < k) {
            comb.add(num);
            findCombination(n, k, num + 1, result, comb);
            comb.remove(comb.size() - 1);
        }
        
        // not add
        findCombination(n, k, num + 1, result, comb);
    }
}

// Solution 2: DFS (best solution)
// Note: For i-th layer, we pick all possile number for i-th element in the solution. After constructing a valid solution, add it to the result.
// Compared with solution 1: (1) Different recursion tree. (2)No pruning. All nodes are valid.
// Time complexity: O(C(n, k) * k). We create a tree with C(n,k) leaves. Generation and Removal takes O(1). Copy takes O(k). -> O(C(n, k) * k)
// Space complexity: O(C(n, k) + k). The number of call stacks: k + Create a list of results: C(n, k) possible solutions. The size of result is C(n, k)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k > n) {
            return result;
        }
        findCombination(n, k, 1, result, new ArrayList<Integer>());
        return result;
    }
    
    private void findCombination(int n, int k, int start, List<List<Integer>> result, List<Integer> solution) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            solution.add(i);
            findCombination(n, k - 1, i + 1, result, solution);
            solution.remove(solution.size() - 1);
        }
    }
}
