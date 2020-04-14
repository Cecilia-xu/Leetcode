// Solution 1: HashMap + prefixSum
// Note: When we change 0 to -1, then the subarray with equal zeros and ones is the subarray with sum 0!
// By doing that, we transform this question to subarray sum equals 0 
// -> find the largest length (get the smaller index when searching for a specific prefixSum) 
// Time complexity: O(n). Scan all the elements in array once.
// Space complexity: O(n). O(n) for the hashmap (worst case): no duplicate prefixSum.
public class Solution {
    /**
     * @param nums: a binary array
     * @return: the maximum length of a contiguous subarray
     */
    public int findMaxLength(int[] nums) {
        // Write your code here
        // If we cannot modify the array directly, we can do this step in calculating the prefixSum
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        HashMap<Integer, Integer> prefixToIndex = new HashMap<>();
        int max = 0, prefixSum = 0;
        prefixToIndex.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            //If we cannot modify the array (replace 0 with -1), use conditions.
            //prefixSum += (nums[i] == 0 ? -1 : 1);
            prefixSum += nums[i];
            if (prefixToIndex.containsKey(prefixSum - 0)) {
                max = Math.max(max, i - prefixToIndex.get(prefixSum - 0));
            }
            else {
                prefixToIndex.put(prefixSum, i);
            }
        }
        return max;
    }
}
