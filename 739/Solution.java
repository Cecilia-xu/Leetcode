// Solution 1: Stack
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        // corner case
        if (T == null || T.length == 0) {
            return T;
        }
        int[] output = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int day = stack.pop();
                output[day] = i - day;
            }
            stack.push(i);
        }
        return output;
    }
}
