// Solution: Intervals
// Note: 1. the array is already sorted 2.keep merging the overlapping intervals (edit newInterval based on its reference!)
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
       
        // skips the intervals that cannot be merged
        int i = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }
        
        // merge all overlapping intervals if newInterval.end >= interval[i][0]
        // Note: the while condition is different from line 9
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        // add the merged intervals
        mergedIntervals.add(newInterval);
        
        // merge the remaining intervals if possible
        while (i < intervals.length) {
            mergedIntervals.add(intervals[i]);
            i++;
        }
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
    
}
