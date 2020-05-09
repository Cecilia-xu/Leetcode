// Solution 1: Array
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int longestPalindrome(String s) {
        // map the letters with its frequency in string s
        int[] lowerCount = new int[26];
        int[] upperCount = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCount[c - 'a']++;
            }
            else {
                upperCount[c - 'A']++;
            }
        }
        
        // Figure out how many pairs can be formed in all letters -> add to res (use pairCount * 2)
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += lowerCount[i] / 2 * 2;
            res += upperCount[i] / 2 * 2;
        }
        
        // !!!!!Important: Check whether we have used all characters in s 
        // if not, some letters' frequencies are odd -> return res + 1
        return res == s.length() ? res : res + 1;
    }
}

// Solution 2: HashSet
// Time complexity: O(n)
// Space complexity: O(n). Worst case: all characters of s exists only once.
class Solution {
    public int longestPalindrome(String s) {
        // Create a hashset to store letters that can not be formed as a pair
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            }
            else {
                set.add(c);   
            }
        }
        // If no letters remained in the set, all letters can formed into pairs -> return s.length()
        // If not, return the number of letters that can be formed as pairs + 1 
        return set.size() == 0 ? s.length() : s.length() - set.size() + 1;
    }
}
