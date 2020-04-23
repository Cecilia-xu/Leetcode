// Solution: DP(similar to lognest increasing sequence)
// Time complexity: O(nlogn) + O(n^2) -> O(n^2)
// Space complexity: O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        
        Arrays.sort(envelopes, (e1, e2) -> (e1[0] - e2[0]));
        
        int[] maxCount = new int[envelopes.length];
        // initialization
        maxCount[0] = 1;
        int res = 1;
        // find maxCount when the outside envelope is envelopes[i]
        for (int i = 1; i < envelopes.length; i++) {
            // at least 1 
            maxCount[i] = 1;
            // find any smaller envelope before envelopes[i]
            for (int j = 0; j < i; j++) {
                // If found, update maxCount
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    maxCount[i] = Math.max(maxCount[i], maxCount[j] + 1);
                }
            }
            
            // After finding all possible cases, update result
            if (maxCount[i] > res) {
                res = Math.max(res, maxCount[i]);
            }
        } 
        
        return res;
    }
}
