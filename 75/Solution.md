# Solution 1: counting sort
## My solution
```Java
class Solution {
    public void sortColors(int[] nums) {
        int[] count = {0,0,0};
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) {
                count[0] ++;
            }
            else if (nums[i] == 1) {
                count[1] ++;
            }
            else if (nums[i] == 2) {
                count[2] ++;
            }
            else {
                assert(nums[i] >= 0 && nums[i] <= 2);
            }
        }
        
        for (int j = 0; j <= count[0] - 1; j ++) {
            nums[j] = 0;
        }
        for (int j = count[0]; j <= count[0] + count[1] - 1; j ++) {
            nums[j] = 1;
        }
        for (int j = count[0] + count[1]; j < nums.length; j ++) {
            nums[j] = 2;
        }
    }
}
```
