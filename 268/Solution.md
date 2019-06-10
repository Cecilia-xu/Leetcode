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
