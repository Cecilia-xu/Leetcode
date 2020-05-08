// Solution: Monotonic stack
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[nums.length];
        Arrays.fill(output, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                int index = stack.pop() % nums.length;
                output[index] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        
        return output;
    }
}
