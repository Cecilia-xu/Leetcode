class Solution {
    public boolean validPalindrome(String s) {
        int count = 0;
        return isValidHelper(s.toCharArray(), count, 0, s.length() - 1);
    }
    
    private boolean isValidHelper(char[] chars, int count, int start, int end) {
        if (count > 1) {
            return false;
        }
        while (start <= end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            }
            else {
                return isValidHelper(chars, count + 1, start, end - 1) || isValidHelper(chars, count + 1, start + 1, end); 
            }
        }
        return true;
        
    }
}
