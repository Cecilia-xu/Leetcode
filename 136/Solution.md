# Solution 1
思路：利用动态数组自带方法实现，只需要遍历一遍即可
时间复杂度 O（n）
空间复杂度 O（1）
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
