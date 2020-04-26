// 这道题最大的收获就是，不要一上来总是在寻找最佳解法而忽视了从暴力解法出发寻找bottleneck的策略。如果一上来就搞明白暴力解法，优化也会简单很多
// Solution 1: Brute Force
// Time complexity: O(n^3) in the worst case
// Space complexity: O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        for (int num : nums) {
            int curLen = 1;
            while (contains(nums, num + 1)) { // This is our bottle neck, we need to take O(n) to prove existence. -> hashset
                num += 1;
                curLen += 1;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
    
    private boolean contains(int[] nums, int target) {
        for (int n: nums) {
            if (n == target) {
                return true;
            }
        }
        return false;
    } 
}

// Solution 2: HashSet
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {      // First improvement: contains in O(1)
            set.add(n);
        }
        int maxLen = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {     // Second improvement: since our checking sequence is from small to large
                int curLen = 1;               // If we need to check num - 1, num will also be considered in the same sequence when checking num - 1. -> ignore this case
                while (set.contains(num + 1)) {
                    num += 1;
                    curLen += 1;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
