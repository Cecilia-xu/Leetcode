# My solution
```Java
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j ++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }
}
```
# Solution 2
1. 写法1：
```Java
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j --;
            }
            else {
                i ++;
            }
        }
        return j;
    }
} 
```
2. 写法2：
```Java
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j --;
            }
            else {
                i ++;
            }
        }
        return j + 1;
    }
}
```
总结：写法1和写法2只是变量的定义不同，要注意始终维护变量的定义。1. 在两种写法中，指针j在第一种写法中指代的是有效区间的length(即第一个已经交换过的数的位置)，指针j在第二种写法中指代的是有效区间最后一个数的位置（即最后一个还没经过交换的位置）。因此循环进行的条件不一样，对于第一种而言，搜索的范围不可能超过有效区间的length，因此要保证i<j。对于第二种解法，搜索的位置应该截止到有效区间最后一个数位置，因此要保证i<=j。2. 具体的条件也会因此发生变化，当发现指针i指代的数字等于val时，需要将这个值换为待查找的其他值，待查找的值在第一种写法中应该是nums\[j-1\],在第二种写法中应该是nums\[j\]。3. 最后的返回值也会发生变化，鉴于需要返回非val的所有值构成的子数组的长度，对于第一种写法，返回的值应该是j，而对于第二种写法，返回的值则是j + 1
