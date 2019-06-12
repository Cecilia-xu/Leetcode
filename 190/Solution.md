# My Solution
> Time complexity: O(1) <br> Space complexity: O(1)
``` Java
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int output = 0;
        for (int i = 0; i < 32; i++) {
            output <<= 1;
            output += (n & 1);
            n >>= 1;
        }
        return output;
    }
}
```
注意：多次出现的几个问题！因为位运算的运算优先级低于逻辑运算符，所以在做位运算的时候，需要给位运算部分单独加括号!!
> 运算优先级
| 优先级| 运算符| 
| :----- | :------：|
|1|() [] |
|2|! +(正)  -(负) ~ ++ --|
|3|* / %|
|4|+(加) -(减)|
|5|<< >> >>>|
|6|< <= > >= instanceof|
|7|==   !=|
|8|&(按位与)|
|9|^|
|10|||
|11|&&|
|12||||
|13|?:|
|14|= += -= *= /= %= &= |= ^=  ~=  <<= >>=   >>>= |
