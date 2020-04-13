// Solution 1: prefixSum + HashMap (Not the oprimal solution)
// Note: totally same with question 150. However, not use the binary condition!
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int prefix = 0, result = 0;
        HashMap<Integer, Integer> prefixToCount = new HashMap<>();
        prefixToCount.put(0, 1);
        for (int a : A) {
            prefix += a;
            if (prefixToCount.containsKey(prefix - S)) {
                result += prefixToCount.get(prefix - S);
            }
            prefixToCount.put(prefix, prefixToCount.getOrDefault(prefix, 0) + 1);
        }
        return result;
    }
}
// Solution 2 : Sliding window (VERY SMART WAY)
// Note: Transfrom this question into subarray sum at most K!
// subarray with sum S = the number of subarrays with sum at most S - the number of subarrays with sum at most S - 1
// Sliding window template revised version (fix end pointers, move start pointers)
// Time complexity: O(n)
// Space comlexity: O(1)
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        return atMostSum(A, S) - atMostSum(A, S - 1);
    }
    
    public int atMostSum(int[] A, int S) {
        if (S < 0) {
            return 0;
        }
        int res = 0, start = 0, sum = S;
        for (int end = 0; end < A.length; end++) {
            sum -= A[end];
            while (sum < 0) {
                sum += A[start];
                start++;
            }
            res += end - start + 1;
        }
        return res;
    }
}
