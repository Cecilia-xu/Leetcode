// Solution: One-scan
// Time complexity: O(n)
// Space complexity: O(1)

// Notes: 1. Read the problem description carefully -> this question is not just find the max result. Note that the lower and the upper num should be in the different array!
// 2. The final result can be found when we try all the possible choices, which means that we should try (the largest in i-th array - globalMin) and (globalMax - the smallest in i-th array)
// In our code, globalMin = lower, globalMax = upper. Since each array is sorted, the largest = the last element in this array, the smallest = the first element in this array

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
    
        int res = Integer.MIN_VALUE;
        int lower = arrays.get(0).get(0);
        int upper = arrays.get(0).get(arrays.get(0).size() - 1);
        
        for (int i = 1; i < arrays.size(); i++) {
            res = Math.max(Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - lower), res);
            res = Math.max(Math.abs(upper - arrays.get(i).get(0)), res);
            lower = Math.min(lower, arrays.get(i).get(0));
            upper = Math.max(upper, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        
        return res;
        
    }
}
