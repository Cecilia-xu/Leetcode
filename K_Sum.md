# K Sum Conclusion
- No.1 Two Sum : using hashmap (Notice: when two numbers are the same e.g. 2 + 2 = 4, do we have 2 different 2 in the array?)
- No.167 Two Sum II - Input Array is sorted : using two pointers (Notice: index starts from 1 in this question)
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
// Solution 1: sorted + two pointers + while loop to deal with duplicate intwo directions
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
```Java
// Solution 2: 2 hash set: set1: record answers we have found / set2: record elements we have visited
public static int uniquePairs(int[] nums, int target){
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;
        for(int num : nums){
            if(set.contains(target-num) && !seen.contains(num)){
                count++;
                seen.add(target-num);
                seen.add(num);
            }
            else if(!set.contains(num)){
                set.add(num);
            }

        }

        return count;
    }
```
#### Two Sum - Greater than target
> Description
Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number. Please return the number of pairs.
> Example
Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)
> Challenge
Do it in O(1) extra space and O(nlogn) time.
```Java
// Solution 1: two pointers
// Sort the array at first.
// If nums[start] + nums[end] > target, it means the number after start + nums[end]. count += end - start
// Else, start++
public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] <= target) {
                i++;
            }
            else {
                count += j - i;
                j--;
            }
        }
        
        return count;
    }
}
```
#### Two Sum - Two Sum - Less than or equal to target 
```Java
// Solution 1: two pointers
public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                min = Math.min(min, target - nums[left] - nums[right]);
                left++;
            }
            else {
                min = Math.min(min, nums[left] + nums[right] - target);
                right--;
            }
        }
        
        return min;
    }
}
```
