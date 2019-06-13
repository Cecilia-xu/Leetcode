# Solution 1 : binary search
> Time complexity: O(logn) <br> Space omplexity: O(1)
```Java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int n = mid ^ 1;
            if (n < nums.length && mid < nums.length && nums[n] == nums[mid]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}
```
注意
1. 数组越界问题需要关注，在if条件中要有所体现
2. XOR的精妙之处
# Solution 2 : bit manipulation
> Time complexity: O(n) <br> Space complexity: O(1)
```Java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }
}
```
