# My solution 1: Integer to String
```Java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = "";
        str += x;
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
                i ++;
                j --;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
```
Note:<br>
1. !!!String -> length(): BRACKET!!!/ Array -> length: NO BRACKET!!!
# My solution 2: No type conversion
```Java
class Solution {
     /**
     * @param x: an integer x.
     * @return: return whether an integer x is a palindrome.
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x;
        int reverse = 0;
        while (y != 0) {
            reverse *= 10;
            reverse += y % 10;
            y = y / 10;
        }
        return reverse == x;
    }
}
```
Note:<br>
1.We need to think about overflow in this question. 
