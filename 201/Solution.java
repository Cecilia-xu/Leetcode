// Solution1: bit manipulation
// Notes: By using n & (n - 1), we can make the bit become 1 when zeros and 1s are at the same bit at the right side.
// We only want to find the bit only when 1s are at this position.
// Time complexity: O(1)
// Space complexity: O(1)
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return m & n;
    }
}

// Solution 2
// Time: O(1)
// Space: o(1)
class Solution {
  public int rangeBitwiseAnd(int m, int n) {
    int shift = 0;
    // find the common 1-bits
    while (m < n) {
      m >>= 1;
      n >>= 1;
      ++shift;
    }
    return m << shift;
  }
}
