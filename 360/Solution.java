// Solution: Array (two pointers) + Math
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] outputs = new int[nums.length];
        int i = 0, j = nums.length - 1;
        int k = 0;
        while (i <= j) {
            int outputI = calculate(nums[i], a, b, c);
            int outputJ = calculate(nums[j], a, b, c);
            if (a > 0) {
                if (outputI > outputJ) {
                    outputs[nums.length - 1 - k] = outputI;
                    k++;
                    i++;
                }
                else {
                    outputs[nums.length - 1 - k] = outputJ;
                    k++;
                    j--;
                }
            }
            else {
                if (outputI < outputJ) {
                    outputs[k] = outputI;
                    k++;
                    i++;
                }
                else {
                    outputs[k] = outputJ;
                    k++;
                    j--;
                }
            }
        }
        return outputs;
    }
    
    private int calculate(int num, int a, int b, int c) {
        return num * num * a + num * b + c;
    }
}
