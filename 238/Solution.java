// Solution 1: Two prefix arrays -> varition(product) - Not the optimal solution
// Time complexity;O(n)
// Space complexity: O(n) (exclude the output array)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];
        leftProducts[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i];
        }
        rightProducts[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i];
        }
        int[] output = new int[nums.length];
        int left = -1, right = 1;
        for (int j = 0; j < output.length; j++) {
            if (left == -1) {
                output[j] = rightProducts[right];
            }
            else if (right == output.length) {
                output[j] = leftProducts[left];
            }
            else {
                output[j] = leftProducts[left] * rightProducts[right];
            }
            left++;
            right++;
        }
        return output;
    }
}
// Solution 2: Optimization space
// Time complexity: O(n)
// Space complexity: O(1) (exclude the output array)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        int rightPrefix = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            output[j] *= rightPrefix;
            rightPrefix *= nums[j];
        }
        return output;
    }
}
