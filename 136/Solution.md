# Solution 1
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
