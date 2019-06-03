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
