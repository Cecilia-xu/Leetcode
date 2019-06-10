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
注意题目的定义，missing number是否会出现在头部和尾部                                       
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
> #### Iterate Hashset
Since Set interface or HashSet class doesn't provide a get() method to retrieve elements, the only way to take out elements from a Set is to iterate over it by using Iterator, or loop over Set using advanced for loop of Java 5. You can get the iterator by calling the iterator() method of Set interface.
