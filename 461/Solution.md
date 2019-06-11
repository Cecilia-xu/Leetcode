# My solution: Bit manipulation
> Time complexity: O(1)<br> Space complexity: O(1)
```Java
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i ++) {
            if ( ((x ^ y) & mask) != 0 ) {
                count ++;
            }
            mask <<= 1;
        }
        return count;
    }
}
```
### optimized solution: 调包法
```Java
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
```
### other solution： 换种方法找x^y中1的位数总数
```Java
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0, xor = x ^ y;
        for (int i = 0; i < 32; i ++) {
            count += (xor >> i) & 1;
        }
        return count;
    }
}
```
相当于就是把XOR右移不同的位数，看是不是1，直到全部右移结束。如果是1,1&1=1，就给count增加1.
