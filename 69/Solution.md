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
# My time limit exceeded solution- binary search
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
# Other's solution- binary search 
```Java
class Solution {
    
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 1, end = x;
        while (start <= end) { 
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
                return mid; 
            else if (mid > x / mid)// Keep checking the left part
                end = mid - 1;
            else
                start = mid + 1;// Keep checking the right part
        }
        return start;
    }     
    
}
```
### Analysis
1. target: x
2. nums: \[0,1 ... x\] (作比较是从1开始的，因为下面涉及了除法，把0单独拿出来讨论)  left = 1, right = x
3. comparsion: mid <= x/mid && ( mid + 1 ) > x / (mid + 1)
### Comparsion & Notes 
1. The question states that the number should be non-negative! ——> Pay attention to the range of the numbers! Be patient to read the question!!!
2.
3.
4.
