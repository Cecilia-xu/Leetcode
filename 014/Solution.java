// Solution: stimulation
// Process: compare two different strings and find their common prefix
// Time complexity: O(n * L). n is the length of strs and L is the length of the string.
// Space complexity: O(1)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // null / empty string
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        int len = strs.length;
        String prefix = strs[0];
        for (int i = 1; i < len; i++) {
            // If not start with current common prefix
            while (!strs[i].startsWith(prefix)) {
                // shorten the prefix until it meets the requirement
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        
        return prefix;
    }
}
