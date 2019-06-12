# My Solution 1: Bit manipulation
> Time complexity: O(1) <br> Space complexity: O(1)
```Java
class Solution {
	public boolean isPowerOfTwo(int n) {
		return (n > 0 && (n & (n - 1)) == 0);
	}
}
```
注意<br>
1. 位运算内部加括号，保证运算优先级！ 
2.n>0必须先单独列出来，因为位运算是可以对负数进行的。凡是涉及到对这个数性质要先考虑正负问题！
# My Solution 2: bitCount method
> Time complexity: O(1) <br> Space complexity: O(1)
``` Java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1 ? true: false;   
    }
}
```
注意：bitCount的函数是在Integer下的写法是Integer.bitCount()
### Optimized solution
``` Java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;   
    }
}
```
注意：本来逻辑运算就会自动返回true/false，不需要画蛇添足用conditional operator
# My Solution 3: Recursion
> Time complexity: O(1) <br> Space complexity: O(1)
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
注意：这个程序就犯了前面提到的错误！没有先验证n>0就开始算！
