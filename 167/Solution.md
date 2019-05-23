# My solution 
```Java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int result[] = {-1,-1};
        int i = 0;
        int j = numbers.length - 1;
        while (numbers[i] + numbers[j] != target && i < j) {
            if (numbers[i] + numbers[j] > target) {
                j --;
            }
            else {
                i ++;
            }
        }
        if (numbers[i] + numbers[j] == target) {
            result[0] = i + 1;
            result[1] = j + 1;
            return result;
        }
        return result;
    }
}
```
