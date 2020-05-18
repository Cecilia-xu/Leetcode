// Solution: array
// Time complexity: O(n)
// Space complexity: O(1)
// Note: You should pay attention to extra condition provided by the question! In this question,  since 1 <= a[i] <= n,
// all elements - 1 might be a valid index. -> use positive/ negative to represent a number that has not been visited or
// a number that has been visited.
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            // visited
            if (nums[index] < 0) {
                res.add(index + 1);
            }
            // not visited
            nums[index] = -nums[index];
        }
        return res;
    }
}
