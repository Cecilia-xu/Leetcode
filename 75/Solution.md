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
## Other's solution
``` Java
class Solution {
    public void sortColors(int[] nums) {
        int[] count = {0,0,0};
        for (int i = 0; i < nums.length; i ++) {
            assert(nums[i] >= 0 && nums[i] <= 2);
            count[nums[i]] ++;
        }
        
        int index = 0;
        for (int j = 0; j < 3; j ++) {
            for (int i = 0; i < count[j]; i ++) {
                nums[index ++] = j;
            }
        }
    }
}

```
## Comparasion & Notes:
1. Use assert to make sure the range of nums\[i\] meets the requirement of the array! [assert用法](https://www.geeksforgeeks.org/assertions-in-java/)
2. Concise: There is no need to use if ... else... in counting. e.g. count\[nums\[i\]\]
3. Create a new variable index, which can make the code more clear!
# Solution 2: Quick sort in 3 ways
