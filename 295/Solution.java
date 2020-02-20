class MedianFinder {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((n1, n2) -> (n2 - n1));
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        }
        
        if (num > maxHeap.peek()) {
            minHeap.add(num);
        }
        
    }
    
    public double findMedian() {

        if (maxHeap.size() < minHeap.size()) {
            while (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }      
        }
        else {
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } 
        }
   
        
        
        if (maxHeap.size() == minHeap.size() + 1) {
            return (double)maxHeap.peek();
        }
        else {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
