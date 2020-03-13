// Solution 1: Two pointers
// Time complexity: O(n)
// Space complexity: O(1)
// Intuition: The trapping water is decided by the shortest one from its maxium left bin/ maxium right bin (based on x-axis)
// Trapping count = sum of trapped water at each position
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int start = 0, end = height.length - 1;
        int maxLeft = height[start], maxRight = height[end];
        int trapCount = 0;
        while (start < end) {
            if (maxLeft < maxRight) {
                trapCount += maxLeft - height[start];
                maxLeft = Math.max(maxLeft, height[++start]);
            }
            else {
                trapCount += maxRight - height[end];
                maxRight = Math.max(maxRight, height[--end]);
            }
        }
        return trapCount;
    }
}

// Solution 2: Stack
// Time complexity: O(n)
// Space complexity: O(n)
// Tapping count = sum of the water that we can decide being trapped (based on height, y axis)
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int cur = 0; cur < height.length; cur++) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int top = stack.pop();
                if (!stack.isEmpty()) {
                    int distance = cur - stack.peek() - 1;
                    int boundHeight = Math.min(height[cur], height[stack.peek()]) - height[top];
                    res += distance * boundHeight;
                }
            }
            stack.push(cur);
        }
        return res;
    }
}
