# Solution 1
``` Java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++){
            if ((n & mask) != 0) {//逻辑运算符优先级低于比较，注意括号
                sum ++;
            }
            mask <<= 1;//位移运算符写法
        }
        return sum;
    }
}
```
# Solution 2
``` Java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum ++;
            n = n & (n-1);
        }
        return sum;
    }
}
```
