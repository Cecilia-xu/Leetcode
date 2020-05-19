// Solution: array
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int one = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                if (one != -1 && i - one - 1 < k) {
                    return false;
                }
                one = i;
            }
        }
        return true;
    }
}
