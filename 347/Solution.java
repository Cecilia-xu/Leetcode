// Solution1: Bucket sort
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        for (int n : nums) {
            numToFreq.put(n, numToFreq.getOrDefault(n, 0) + 1);
        }
        
        List[] buckets = new List[nums.length + 1];
        for (int n : numToFreq.keySet()) {
            int count = numToFreq.get(n);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<Integer>();
            }
            buckets[count].add(n);
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        
        for (int i = nums.length; i > 0 && ans.size() < k; i--) {
            if (buckets[i] != null) {
                ans.addAll(buckets[i]);
            }
        }
        
        return ans;
    }
}
