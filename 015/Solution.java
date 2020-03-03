// Solution: traverse + two pointers
// Notice: must deduplicte the elements by comparing with the number that has been checked.
// Learnt: the structure of the code: split the code into different parts, one part achieves one function
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i + 1, nums.length - 1, -nums[i], results);
        }
        return results;
    }
    
    private void twoSum(int[] nums, int start, int end, int sum, List<List<Integer>> results) {
        while(start < end) {
            if (nums[start] + nums[end] == sum) {
                List<Integer> newItem = new ArrayList<>();
                newItem.add(-sum);
                newItem.add(nums[start]);
                newItem.add(nums[end]);
                results.add(newItem);
                start++;
                end--;
                
                while (start < nums.length && nums[start] == nums[start - 1]) {
                    start++;
                }
                
                while (end > start && nums[end] == nums[end + 1]) {
                    end--;
                }
            }
            else if (nums[start] + nums[end] > sum) {
                end--;
            }
            else {
                start++;
            }
        }
    }
}
