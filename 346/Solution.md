# Solution
> Time complexity: O(1)<br> Space complexity: O(n)
```Java
class MovingAverage {
    private Queue<Integer> nums;
    double preSum = 0.0;
    int maxSize;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.nums = new LinkedList<Integer>();  
        this.maxSize = size;
    }
    
    public double next(int val) {
        if (maxSize == nums.size()){
            preSum -= nums.remove();
        }
        preSum += val;
        nums.add(val);
        return preSum / nums.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
 ```
 Note:<br>
 1. last part of creating a queue: new linkedList()
 2. When returning a double type number, define a double variable to store this number. i.e. double + int= double
 3. Computing average: we should divide the size of linked list because the linked list does not always contain a specific size of elements.i.e. 1,2 in the example case
