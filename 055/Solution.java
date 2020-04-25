// Solution 1: dynamic programming
// Time complexity: O(n^2)
// Space complexity: O(n)
// Equation: isValid[i] = isValid[j] && nums[j] >= i - j (j = 0 ... i - 1, prove existence)
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
// Solution 2: Greedy
// Notes: We assume we can get to the destination(lastPos) we found so far, and check where we departure from. 
// If we can prove that we departure from nums[0], which means our assumption is correct.
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
