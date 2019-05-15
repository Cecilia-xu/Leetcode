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
# My time limit exceeded solution
```Java
class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        int left = 0;
        int right = x;
        while (left * left <= right * right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return mid;
            }
            else if (mid * mid > x) {
                left = mid -1;
            }
            else {
                right = mid + 1;
            }
        }
        return left;
    }
}
```
