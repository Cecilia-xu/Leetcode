// Solution: Sort + two pointers
// Time complexity: O(n^3)
// Space complexity: O(1)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int threeSum = target - nums[i];
            findThreeSum(res, nums, i + 1, threeSum);
        }
        
        return res;
    }
    
    private void findThreeSum(List<List<Integer>> res, int[] nums, int start, int target) {
        for (int i = start; i < nums.length - 2; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            int twoSum = target - nums[i];
            findTwoSum(res, nums, i + 1, twoSum, start - 1);
        }
    }
    
    private void findTwoSum(List<List<Integer>> res, int[] nums, int start, int target, int firstNum) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                List<Integer> solution = new ArrayList<>();
                solution.add(nums[firstNum]);
                solution.add(nums[start - 1]);
                solution.add(nums[i]);
                solution.add(nums[j]);
                res.add(solution);
                while (i < j && nums[i + 1] == nums[i]) {
                    i++;
                }
                while (i < j && nums[j - 1] == nums[j]) {
                    j--;
                }
                i++;
                j--;
            }
            else if (nums[i] + nums[j] > target) {
                j--;
            }
            else {
                i++;
            }
        }
    }
}
