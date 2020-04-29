// Solution: DP + HashMap
// Similar problem: LIS(longest increasing subsequence)
// Difference: not just the trend, but the specific number -> hashmap is more efficient
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> numToLength = new HashMap<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int length = numToLength.getOrDefault((arr[i] - difference), 0) + 1;
            res = Math.max(length, res);
            numToLength.put(arr[i], length);
        }
        return res;
    }
}
