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
// Solution 2.1: Min heap
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        for (int n : nums) {
            numToFreq.put(n, numToFreq.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> numToFreq.get(n1) - numToFreq.get(n2));
        int count = 0;
        for (int n : numToFreq.keySet()) {
            if (count < k) {
                minHeap.add(n);
                
            }
            else {
                if (numToFreq.get(n) > numToFreq.get(minHeap.peek())) {
                    minHeap.poll();
                    minHeap.add(n);
                }
            }
            count++;
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        while (!minHeap.isEmpty()) {
            ans.add(minHeap.poll());
            Collections.reverse(ans);
        }
        
        return ans;
    }
}
// Solution 2.2: Min Heap
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        for (int n : nums) {
            numToFreq.put(n, numToFreq.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> numToFreq.get(n1) - numToFreq.get(n2));
        for (int n : numToFreq.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        while (!minHeap.isEmpty()) {
            ans.add(minHeap.poll());
            Collections.reverse(ans);
        }
        
        return ans;
    }
}
