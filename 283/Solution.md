# Solution 1
``` Java
class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> newNums = new ArrayList<>();
        for (int i = 0 ; i < nums.length; i ++) {
            if (nums[i] != 0) {
                newNums.add(nums[i]);
            }
        }
        for (int j = 0; j < newNums.size(); j ++) {
            nums[j] = newNums.get(j);
        }
        for (int j = newNums.size(); j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
```
注意：ArrayList获得size是调用ArrayList class里的size方法，所以需要加括号; array获得length不需要加括号，因为只是array中的一个attribute，不是method
# Solution 2
```Java
class Solution {
    public void moveZeroes(int[] nums) {
        // new index
        int i = 0;
        for (int j = 0; j < nums.length; j ++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i ++;
            }
        }
        while (i < nums.length) {
            nums[i] = 0;
            i ++;
        }
    }
}
```
# Solution 3
```Java
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j ++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i ++;
            }
        }
    }
}
```
注:swap方法最好单独写，保证每个method实现1个功能，使代码可读性更强
```Java
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j ++) {
            if (nums[j] != 0) {
                swap (i, j, nums);
                i ++;
            }
        }        
    }
    public void swap (int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
