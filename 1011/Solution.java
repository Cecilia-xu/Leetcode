// Solution: binary search
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int capacity = mid;
            int days = 0;
            for (int w : weights) {
                capacity -= w;
                if (capacity < 0) {
                    days++;
                    capacity = mid - w;
                }
            }
            if (capacity >= 0) {
                days += 1;
            }
            
            if (days <= D) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
            
        }
        
        return left;
    }
}
