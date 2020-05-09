// Solution: two pointers
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] letters = s.toLowerCase().toCharArray();
        while (i < j) {
            while(i < j && !Character.isLetterOrDigit(letters[i])) {
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(letters[j])) {
                j--;
            }
            if (i < j && letters[i] != letters[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
