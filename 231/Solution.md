# My Solution
``` Java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        else if (n % 2 == 0 && n != 0 ) {
            return isPowerOfTwo(n/2);
        }
        return false;
    }
}
```
