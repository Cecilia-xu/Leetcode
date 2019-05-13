# Solution
```Java
class Solution {
    public int pivotIndex(int[] nums) {
        int sumNums = 0;
        int leftNums = 0;
        for (int num : nums) {
            sumNums += num; 
        }
        for (int i = 0; i < nums.length; ++ i) {
            if (leftNums == sumNums - nums[i] - leftNums) {
                return i;
            }
            leftNums += nums[i];
        }
        
        return -1;
    }
}
```
