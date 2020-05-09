// Solution: Binary search
// Time complexity: O(logn)
// Space complexity: O(1)
// Note: Multiplication operation -> Pay attention to overflow error! -> use "long" instead of "int"
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        long low = 0, high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == num) {
                return true;
            }
            if (mid * mid > num) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }
}
