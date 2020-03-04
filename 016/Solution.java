// Solution: combine with 3Sum + two sum: closest to target
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int closestThreeSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int complement = target - nums[i];
            int start = i + 1, end = nums.length - 1;
            while(start < end) {
                int twoSum = nums[start] + nums[end];
                if (twoSum == complement) {
                    return target;
                }
                else if (twoSum > complement) {
                    if (min > Math.abs(twoSum + nums[i] - target)) {
                        min = Math.abs(twoSum + nums[i] - target);
                        closestThreeSum = twoSum + nums[i];
                    }
                    end--;
                }
                else {
                    if (min > Math.abs(twoSum + nums[i] - target)) {
                        min = Math.abs(twoSum + nums[i] - target);
                        closestThreeSum = twoSum + nums[i];
                    }                
                    start++;
                }
            }
        }
        return closestThreeSum;
    }
    
}
