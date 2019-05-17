# My solution
```Java
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > nums[start]) {
                if (nums[start] == target) {
                    return start;
                }
                else if (nums[mid] > target && nums[start] < target) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if (nums[end] == target) {
                    return end;
                }
                else if (nums[mid] < target && nums[end] > target) {
                    start = mid + 1;
                }
                else {
                   end = mid - 1;
                }
            }
        }
        return -1;
    }
}
```
Note: 在思考区间的时候，要注意全面无遗漏，等于的情况必须算进其中某一个类，否则就会出现某些testcase有问题的情况！
