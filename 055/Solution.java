// Solution 1: dynamic programming
// Time complexity: O(n^2)
// Space complexity: O(n)
// Refer to: sample questions
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] isValid = new boolean[nums.length];
        isValid[0] = true;
        for (int i = 1; i < nums.length; i++) {
            isValid[i] = false;
            for (int j = 0; j < i; j++) {
                if (isValid[j] && nums[j] >= i - j) {
                    isValid[i] = true; 
                    break;
                }
            }
        }
        return isValid[nums.length - 1];
    }
}
// Solution 2: Greedy ???
// TIme complexity: O(n)
// Space complexity: O(1)
public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
