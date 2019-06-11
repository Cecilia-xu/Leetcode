# My solution： Bit manipulation
> Time complexity: O(1) (Since our operation is performed in 32 bits of each number, the number of operations is 32 in the worst case. Therefore, the time complexity is O(1).) <br> Space complexity: O(1)
```Java
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
注意：完全可以用递归写的更简洁
