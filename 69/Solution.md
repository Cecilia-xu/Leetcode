# My brute-force solution
```Java
class Solution {
    public int mySqrt(int x) {
        if (x >= 0) {
            double result = Math.sqrt(x);
            return (int)result / 1;
        }
        return -1;
    }
}
```
Note： 此为修改后解法，注意关注x=0的情况，以及Math.sqrt的返回值类型其实是double。此法在真实面试中有些作弊，感觉就是在调用method。。
