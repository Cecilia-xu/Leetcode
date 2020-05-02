// Solution 1: sliding window + hashset (Not the optimal solution)
// Time complexity: O(n)
// Space complexity: O(n)
// Note: use template to avoid mistakes!
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int end = 0;
        int maxLen = Integer.MIN_VALUE;
        for (start = 0; start < s.length(); start++) {
            while (end < s.length() && !set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            }
            maxLen = Math.max(maxLen, end - start);
            set.remove(s.charAt(start));
        }
        return maxLen == Integer.MIN_VALUE ? 0: count;
    }
}
// Solution 2: sliding window + int array(represent the frequency of characters)
// Time complexity: O(n)
// Space complexity: O(256) -> O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] visited = new char[256];
        char[] letters = s.toCharArray();
        int end = 0;
        int maxLen = Integer.MIN_VALUE;
        
        for (int start = 0; start < letters.length; start++) { 
            while (end < letters.length && visited[letters[end]] == 0) {
                visited[letters[end]]++;
                end++;
            }
            int len = end - start;
            maxLen = Math.max(maxLen, len);
            visited[letters[start]]--;
        }
        
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
