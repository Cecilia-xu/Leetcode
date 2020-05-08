// Solution: Monotonic stack
// Time complexity: O(n + m). n = nums1.length, m = nums2.length
// Space complexity: O(n + m). O(n) hashmap + O(m) stack
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums1.length ; i++) {
            numToIndex.put(nums1[i], i);
        }
        int[] output = new int[nums1.length];
        Arrays.fill(output, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int num = stack.pop();
                if (numToIndex.containsKey(num)) {
                    output[numToIndex.get(num)] = nums2[i];
                }
            }
            stack.push(nums2[i]);
        }
        return output;
    }
}
