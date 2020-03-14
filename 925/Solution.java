// Solution: Two pointers
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        char[] nameChars = name.toCharArray();
        char[] typedChars = typed.toCharArray();
        // compare each characters in name
        while (i < nameChars.length && j < typedChars.length) {
            if (nameChars[i] == typedChars[j]) {
                i++;
                j++;
            }
            else if (i > 0 && typedChars[j] == nameChars[i - 1]) {
                j++;
            }
            else {
                return false;
            }
        }
        
        // if we have checked all characters in typed and there'are still some characters remaining in name, return false
        if (i < nameChars.length && j == typedChars.length) {
            return false;
        }
        
        // If we have checked all characters in name, then we need to check the remaining characters in typed.
        // If they are not the last character in name, we return false.
        while (j < typedChars.length && i == nameChars.length) {
            if (typedChars[j] != nameChars[i - 1]) {
                return false;
            }
            j++;
        }
        
        return true;
    }
}
