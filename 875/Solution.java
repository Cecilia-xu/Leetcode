// Binary search
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = 0;
        for (int p : piles) {
            right = Math.max(right, p);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int p : piles) {
                hours += (p + mid - 1) / mid;
            }
            if (hours == H) {
                return mid;
            }
            else if (hours > H) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
