// Solution: priority queue
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> (n2 - n1));
        for (int s : stones) {
            maxHeap.add(s);
        }
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (x != y) {
                maxHeap.add(y - x);
            }
        }
        
        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}
