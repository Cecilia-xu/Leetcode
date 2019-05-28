# My solution
```Java
class Solution {
    public int dominantIndex(int[] nums) {
        int largestNum = 0;
        int largestIndex = 0;
        int val = 0;
        // find the largest number in the array
        for (int i = 0; i < nums.length;  ++ i) {
            if (nums[i] > largestNum) {
                //record the largest number and largest index(because i will increase at the same time)
                largestNum = nums[i];
                largestIndex = i;
            }
        }
        // find the second largest number in the array
        for (int j = 0; j < nums.length; ++ j) {
            if (nums[j] > val && nums[j] != largestNum) {
                val = nums[j];
            }
        }
        if (largestNum >=  2 * val) {
            return largestIndex;
        }
        return -1;
    }
}
```
# Official Solution
```Java
class Solution {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }
}
```
Note：1. There is no need to create a new variable maxNumber to make comparsion. Finding maxIndex is enough.
2.There is no need to find the second largest number. Just compare it with twice of each element.
