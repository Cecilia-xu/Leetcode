# My Solution
``` Java
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = -1;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        
        while (left < nums.length) {
            if (sum < s && right + 1 < nums.length) {
                sum += nums[++ right];
            }
            else {
                sum -= nums[left ++];
            }
            
            if (sum >= s)  
                res = Math.min(res, right - left + 1);
        }
        
        return (res == Integer.MAX_VALUE? 0 : res);
    }
}
```
# Official solution
```Java
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            
            while (sum >= s) {
                res = Math.min(res,i - left + 1);
                sum -= nums[left ++];
            }
        }
             
        return (res == Integer.MAX_VALUE? 0 : res);
    }
}
```
Note:
1.该解法将i看作右指针，它的递增趋势是不变的，因此可以直接用for循环写；
2.减少了比较的次数，提升了效率
3.注意while处的逻辑，只要是满足sum>=s都需要记录下当时的res，然后再减掉最左边指针对应值并右移left
