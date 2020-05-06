// Solution: monotonic stack
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxArea = 0;
        // * Note here: i can be heights.length, which means we still need to check rectangles that do not die until the end
        for (int i = 1; i <= heights.length; i++) {
            //* Same reason for height = -1
            int height = (i == heights.length ? -1 : heights[i]);
            // Do no forget to check stack.isEmpty() in the while loop
            while (!stack.isEmpty() && heights[stack.peek()] > height) {
                int h = heights[stack.pop()];
                int w = (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
