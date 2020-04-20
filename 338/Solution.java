// Solution: bits type dp
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int[] countBits(int num) {
        int[] counts = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            counts[i] = (i & 1) + counts[i >> 1];
        }
        return counts;
    }
}
