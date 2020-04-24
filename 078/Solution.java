// Solution: DFS
// Notes: use similar method like tree pre-order traversal -> only add leaf node (after n-th layer)
// Time complexity: O(n * 2^n)
// Space complexity: O(n * 2^n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        findSubset(result, nums, 0, solution);
        return result;
    }
    
    private void findSubset(List<List<Integer>> result, int[] nums, int layers, List<Integer> solution) {
        // base case
        if (layers == nums.length) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }
        
        // case 1: add
        solution.add(nums[layers]);
        findSubset(result, nums, layers + 1, solution);
            
        solution.remove(solution.indexOf(nums[layers]));
        // case 2: not add
        findSubset(result, nums, layers + 1, solution);
           
    }
}
