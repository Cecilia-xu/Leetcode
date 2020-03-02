// Solution 1: hashmap - the continous subarray sum = all presum - presum before the subarray = k
// Therefore, we should find the count number of the presum before the subrray whose sum = all presum - k
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> presumToCount = new HashMap<>();
        int presum = 0, count = 0;
        presumToCount.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            if (presumToCount.containsKey(presum - k)) {
                count += presumToCount.get(presum - k);
            }
            presumToCount.put(presum, presumToCount.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
