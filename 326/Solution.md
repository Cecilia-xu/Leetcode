# My Solution
``` Java
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        else if (n % 3 == 0 & n != 0) {
            return isPowerOfThree (n/3);
        }
        return false;
    }
}
```
Time complexity O(log3 n)<br>
Space complexity O(1) <br>

# Official Solution
