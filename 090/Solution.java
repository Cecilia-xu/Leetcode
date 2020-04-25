// Solution: DFS
// Time complexity: O(n * 2^n). n - copy subset to result list, 2^n : the number of nodes in the recursion tree
// Space complexity: O(n + k). n - the number of call stacks, k - the length of result
// How to remove duplicates? 
// (1) sort the array (add elements from small to large)
// (2) ignore the case that can be a duplicate of the case in the previous layer even though we might check this case first
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        findSubsets(result, new ArrayList<Integer>(), nums, 0, -1);
        return result;
    }
    
    private void findSubsets(List<List<Integer>> result, List<Integer> subset, int[] nums, int index, int lastIndex) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        
        // case 1: not add nums[index]
        findSubsets(result, subset, nums, index + 1, lastIndex);

        // case 2: add nums[index]
        if (index > 0 && nums[index] == nums[index - 1] && lastIndex != index - 1) {
            return;
        }
        subset.add(nums[index]);
        findSubsets(result, subset, nums, index + 1, index);
        
        // backtracking
        subset.remove(subset.size() - 1);
    }
}
