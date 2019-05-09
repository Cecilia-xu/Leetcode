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
public class Solution1 {

    public void sortColors(int[] nums) {

        int[] count = {0, 0, 0};    // 存放0, 1, 2三个元素的频率
        for(int i = 0 ; i < nums.length ; i ++){
            assert nums[i] >= 0 && nums[i] <= 2;
            count[nums[i]] ++;
        }

        int index = 0;
        for(int i = 0 ; i < count[0] ; i ++)
            nums[index++] = 0;
        for(int i = 0 ; i < count[1] ; i ++)
            nums[index++] = 1;
        for(int i = 0 ; i < count[2] ; i ++)
            nums[index++] = 2;
    }

```
## Comparasion & Notes:
1. Use assert! [assert用法](https://www.geeksforgeeks.org/assertions-in-java/)
2. Create a new variable index, which can make the code more clear!
