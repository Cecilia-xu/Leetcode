# My Solution1: Two-pass Hash table
> Time complexity: O(n) <br> Space complexity:O(n)
```Java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {-1,-1};
        HashMap<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            numMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i ++) {
            if (numMap.containsKey(target - nums[i]) && numMap.get(target - nums[i]) != i) {
                res[0] = i;
                res[1] = numMap.get(target - nums[i]);
                break;
            } 
        }
        return res;
    }
}
```
### Optimized Solution1: more clear
```Java 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            numMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i ++) {
           int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
                break;
            } 
        }
        return return new int[]{-1,-1};
    }
}
```
Note:<br>
1. Basic operation in HashMap:
- create new HashMap: <Key, Value> - two type
- add something in HashMap: use "put" not "add"
- get VALUE in HashMap: use "get"
- find whether a key exist or not: use "containsKey"
2. Not neccessary to create "res" array: use "new" Key word
3. Choose correct key/value: what we need to find can be treated as value in the map. In this question, we have to find the index of two numbers. Therefore, the index is the value in the map.
# Solution2: One-pass Hash Table
> Time complexity: O(n)<br> Space complexity: O(n)
```Java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)){
                return new int[]{numMap.get(complement),i};
            }
            else {
                numMap.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
```
