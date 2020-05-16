// Solution1: DFS (build solution layer by layer)
// The recursion will have nums.length() levels. For i-th level, there are nums.length() - i nodes for each ancester.
// Use boolean[] added to recorded whether the element is used or not.
// Time complexity: O(N! * N)
// Space complexity: O(N)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] added = new boolean[nums.length];
        dfs(res, new ArrayList<Integer>(), nums, added);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> solution, int[] nums, boolean[] added){
        if (solution.size() == nums.length) {
            res.add(new ArrayList<Integer>(solution));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!added[i]) {
                solution.add(nums[i]);
                added[i] = true;
                dfs(res, solution, nums, added);
                // *Recover both solution and added
                solution.remove(solution.size() - 1);
                added[i] = false;
            }
        }
    }
}

// Solution 2: DFS(swap - swap)
// The recursion tree will have nums.length - 1 layers. For i-th layer, there are num.length - i child nodes for each ancestor.
// Time complexity: O(N * N!)
// Space complexity: O(N)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(res, nums, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, int[] nums, int start){
        if (start == nums.length - 1) {
            List<Integer> solution = new ArrayList<>();
            for (int n : nums) {
                solution.add(n);
            }
            res.add(solution);
        }
        
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            dfs(res, nums, start + 1);
            // recover
            swap(nums, start, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
