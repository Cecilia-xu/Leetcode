// Solution 1: 
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        } 
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int count = 0;
        int earlyEnd = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[earlyEnd]) {
                count += 1;
            }
            else {
                earlyEnd += 1;
            }
        }
        return count;
    }
}

// Solution 2: Min Heap
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        PriorityQueue<Integer> minEndTimeHeap = new PriorityQueue<>();
        int count = 0;
        for (int[] i : intervals) {
            if (minEndTimeHeap.isEmpty() || i[0] < minEndTimeHeap.peek()) {
                count++;
                minEndTimeHeap.add(i[1]);
            }
            else {
                minEndTimeHeap.poll();
                minEndTimeHeap.add(i[1]);
            }
        }
        return count;
    }
}
