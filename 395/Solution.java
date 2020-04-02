// Solution 1: divide and conquer
// Time complexity: O(nlogn)
// Space: O(logn)
// Note: If we find a letter whose frequent is less than k, then the longest substring should be either on the left side of this letter, or on the right side of the letter.
class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        
        int[] freq = new int[26];
        char[] letters = s.toCharArray();
        for (char c : letters) {
            freq[c - 'a']++;
        }
        
        int left = 0, right = s.length();
        for (int i = 0; i < letters.length; i++) {
            if (freq[letters[i] - 'a'] < k) {
                return Math.max(longestSubstring(s.substring(left, i), k), longestSubstring(s.substring(left + 1, right), k));
            }
        }
        
        return s.length();
    }
}
