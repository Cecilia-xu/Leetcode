class Solution {
    public boolean detectCapitalUse(String word) {
        boolean res = true;
        if (word.length() == 1) {
            return true;
        }
        
        if (Character.isLowerCase(word.charAt(0))) {
            return isAllLowerCase(word, 1);
        }
        else if (Character.isLowerCase(word.charAt(1))) {
            return isAllLowerCase(word, 2);
        }
        else {
            return isAllUpperCase(word, 2);
        }
    }
    
    private boolean isAllLowerCase(String word, int start) {
        if (word.length() == start) {
            return true;
        }
        
        for (int i = start; i < word.length(); i++) {
            if (!Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isAllUpperCase(String word, int start) {
        if (word.length() == start) {
            return true;
        }
        
        for (int i = start; i < word.length(); i++) {
            if (!Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
