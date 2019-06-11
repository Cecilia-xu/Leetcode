# My solution
```
class Solution {
    public int getSum(int a, int b) {
        int temp;
        while (b != 0) {
            temp = a;
            a = temp ^ b;
            b = temp & b;
            b = b << 1;
        }
        return a;
    }
}
```
### Optimized solution 1
``` Java
class Solution {
    public int getSum(int a, int b) {
        int temp;
        while (b != 0) {
            temp = a & b;
            a = a ^ b;
            b = temp << 1;
        }
        return a;
    }
}
```
### Optimized solution 2: recursion
``` Java
class Solution {
    public int getSum(int a, int b) {
        return b == 0 ?: a : getSum(a ^ b, (a & b) << 1);
    }
}
```
