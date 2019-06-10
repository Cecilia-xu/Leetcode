# My solution 1 : sort
> Time complexity: O(nlogn) <not accepted> <br> Space complexity: O(1)
``` Java
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            if(i != nums[i]){
                return i;
            }
        }
        // Important: Missing number can be the last element of the array
        return nums.length;
    }
}
```
注意:题目的定义，missing number是否会出现在头部和尾部                                       
# My solution 2: HashSet
> Time complexity：O(n) (accpected) <br> Space complexity: O(n) (not accepted)
```Java
class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int n: nums) {
            numSet.add(n);
        }
        for (int i = 0; i < numSet.size() ; i ++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }
        return nums.length;
    }
}
```
注意：HashSet没有put方法！因此在这个题里我们可以使用contains()方法
> ### Iterate Hashset
Since Set interface or HashSet class doesn't provide a get() method to retrieve elements, the only way to take out elements from a Set is to iterate over it by using Iterator, or loop over Set using advanced for loop of Java 5. You can get the iterator by calling the iterator() method of Set interface.
# Solution 3 : Math - Gauss' Formula
``` Java
class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = (0 + nums.length) * (nums.length + 1) / 2;
        int realSum = 0;
        for (int num: nums) {
            realSum += num;
        }
        return expectedSum - realSum;
    }
}
```
注意：写之前要想清楚，理论上以及实际的序列是什么样的，首项？末项？项数？<br>
### Optimize space
``` Java
class Solution {
    public int missingNumber(int[] nums) {
        int sum = (0 + nums.length) * (nums.length + 1) / 2;
        for (int num: nums) {
            sum -= num;
        }
        return sum;
    }
}
```
# Solution 4: Binary search
``` Java
class Solution {
    public int missingNumber(int[] nums) { 
        Arrays.sort(nums);
        //binary search
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // when nums[mid] > mid, the missing number is in the left range. Update right.        
            if (nums[mid] > mid) {
                right = mid;
            }
            // otherwise, the missing number is in the right range. Update left.
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
```
注意
1. 此方法比方法1效率更高，在已经sorted的数组中，binary search优于linear search的效率
2. binary search仍然需要进一步理解，锁定最终的范围。边界和while条件变化的同步；if里的条件反映的是左右范围的变化
# Solution 5:bit minipulation
``` Java
class Solution {
    public int missingNumber(int[] nums) { //binary search
        int missing = nums.length;
        for (int i = 0; i < nums.length; i ++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
```
