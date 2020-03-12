// Solution 1: sliding window + hashset
// Time complexity: o(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int start, end = 0;
        int count = Integer.MIN_VALUE;
        for (start = 0; start < s.length(); start++) {
            while (end < s.length() && !set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            }
            if (end <= s.length()) {
                count = Math.max(count, end - start);
                set.remove(s.charAt(start));
            }
        }
        return count == Integer.MIN_VALUE ? 0: count;
    }
}
