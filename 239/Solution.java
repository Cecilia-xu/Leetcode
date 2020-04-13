// Solution 1: Max Heap (not the optimal solution)
// Time complexity: O(nlogk). Poll and remove in O(logk) * (n - k) + heapify O(k) -> O(nlogk)
// Space complexity: O(n). heap O(k) + result array O(n - k + 1) -> O(n)
// Note: Heap can contain duplicate elements! Also, if we call remove(element), just remove one element!
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);    
        for (int i = 0; i < k - 1; i++) {
            maxHeap.add(nums[i]);
        }       
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = k - 1; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            res[index++] = maxHeap.peek();
            int start = nums[i - k + 1];
            maxHeap.remove(start);
        }
        return res;
    }
}
// Solution 2: Deque(单调)
// Time complexity: O(n)
// Space complexity: O(n). O(k) deque + O(n - k + 1) result array -> O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int count = 0, start = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (count < k && !deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            count++;
            if (count == k) {
                res[index++] = deque.peekFirst();
                if (nums[start] == deque.peekFirst()) {
                    deque.pollFirst();
                }
                count--;
                start++;
            }
        }
        return res;
    }
}
