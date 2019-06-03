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
