# K Sum Conclusion
- No.1 Two Sum : using hashmap (Notice: when two numbers are the same e.g. 2 + 2 = 4, do we have 2 different 2 in the array?)
- No.167 Two Sum II - Input Array is sorted : using two pointers
- No.170 Two Sum III - Data Structure design: combination of I and II
- No.653 Two Sum IV - Input is a BST: inorder is sorted array + two pointers
- No.1214 Two Sum BSTs: inorder- two sorted array + two pointers / two sets 
- No.1099 Two Sum: the larget sum less than k - two pointers 

### Other questions
#### Two Sum- unique pairs
> Description
Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.

> Example
Given nums = [1,1,2,45,46,46], target = 47
return 2

1 + 46 = 47
2 + 45 = 47

```Java
public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            }
            else if (nums[left] + nums[right] > target) {
                right--;
            }
            else {
                count++;
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
        
        return count;
    }
}
```
