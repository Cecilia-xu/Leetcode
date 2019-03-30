# Problem
Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Example 1:
Input: [2,2,1]
Output: 1
Example 2:
Input: [4,1,2,1,2]
Output: 4
# Solution 1
思路1：利用list实现
+ 时间复杂度 O（n^2）
<br> We iterate through \text{nums}nums, taking O(n)O(n) time. We search the whole list to find whether there is duplicate number, taking O(n)O(n) time. Because search is in the for loop, so we have to multiply both time complexities which is O(n^2)O(n 
2
 ).
+ 空间复杂度 O（n）
<br> Space complexity : O(n)O(n). We need a list of size nn to contain elements in \text{nums}nums. 

```Java
class Solution {
    public int singleNumber(int[] nums) {
        ArrayList<Integer> newNums = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (! newNums.contains(nums[i]) ) {
                newNums.add(nums[i]);
            }
            else {
                newNums.remove(newNums.indexOf(nums[i]));
            }
        }
        return newNums.get(0);
    }
}
```
# Solution 2
```Java
class Solution {
    public int singleNumber(int[] nums) {
        
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				set.remove(nums[i]);
			} else {
				set.add(nums[i]);
			}
		}
		return set.iterator().next();
	
    }
}
```
# Solution 3
```Java
class Solution {
    public int singleNumber(int[] nums) {
        int result;
        
        if (nums.length == 0) {
            return (0);
        }
        
        result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        
        return (result);
    }
}
```
