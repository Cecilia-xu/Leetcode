// Solution: Two pointers (move zeros variation)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return getFinalString(S).equals(getFinalString(T));
    }
    
    public String getFinalString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] letters = s.toCharArray();
        int j = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != '#') {
                letters[j] = letters[i];
                j++;
            }
            else if (j > 0){
                j--;
            }
        }
        return new String(letters).substring(0, j);
    }
}
