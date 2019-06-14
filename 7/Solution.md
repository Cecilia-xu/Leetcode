# My solution
> Time complexity: O(logn) <br> Space complexity: O(1)
```Java
class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + (long) x % 10;
            x = x / 10;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)res;
    }
}
```
Note: Transfer type!!!Even though "long" and "int" can both represent integer, we should transfer the type when we use both of them.
