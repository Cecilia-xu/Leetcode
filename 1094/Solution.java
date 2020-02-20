// Solution1: Heap
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> minEndHeap = new PriorityQueue<>((trip1, trip2) -> (trip1[2] - trip2[2]));
        PriorityQueue<int[]> minStartHeap = new PriorityQueue<>((trip1, trip2) -> (trip1[1] - trip2[1]));       
        for (int i = 0; i < trips.length; i++) {
            minStartHeap.add(trips[i]);
            minEndHeap.add(trips[i]);
            if (trips[i][0] > capacity) return false;
        }
        
        int count = 0;
        while(!minStartHeap.isEmpty()) {
            while (!minStartHeap.isEmpty() && minStartHeap.peek()[1] < minEndHeap.peek()[2]) {
                count += minStartHeap.poll()[0];
            }
            if (count > capacity) {
                return false;
            } 
            count -= minEndHeap.poll()[0];
        }
        
        return true;
    }
}
