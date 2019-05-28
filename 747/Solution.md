# My solution
Intuition: Find the largest number and the second largest number in the array. If the largest number is two times larger than the second largest number, then return i.
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
Intuition: Find the largest number in the array. If there is a number which mutiple 2 is larger than the largest number, we return -1. Otherwise, return the index of the largest number.
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
# Comparasion
1. There is no need to create a new variable maxNumber to store the number. Finding maxIndex is enough.
2. There is no need to find the second largest number. Just compare it with twice of each element. If we
