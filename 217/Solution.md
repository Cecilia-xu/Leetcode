# My solution 1: Hash table
> Time complexity: O(n) <br> Space complexity: O(n)
```Java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            if (!numSet.contains(nums[i])) {
                numSet.add(nums[i]);
            }
            else {
                return true;
            }
        }
        return false;
    }
}
```
# My solution 2: Sorting
> Time complexity: O(nlogn) <br> Space complexity: O(1)
```Java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
```
Note: When we need to return a boolean, understand when to return true/false at first!!
