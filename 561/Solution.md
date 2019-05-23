# My solution(Brute-Force)
```Java
//Time complexity: O(nlogn)
//Space complexity: O(1)
class Solution {
    public int arrayPairSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums); // Note!How to use sort!
        int result = 0;
        for (int i = 0; i < length; i ++) {
            if (i % 2 == 0) {
                result += nums[i];
            }
        }
        return result;
    }
}
```
# Official Solution: similar to my solution
```Java
//Time complexity: O(nlogn)
//Space complexity: O(1)
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) { //注意：怎样把代码写的更加简洁
            sum += nums[i];
        }
        return sum;
    }
}
```
