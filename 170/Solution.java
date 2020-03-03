// Two sum: data structure design
// Solution 1: similar to Two Sum I, use hashmap
class TwoSum {
    private HashMap<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        this.map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    // O(1)
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    // O(n)
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int complement = value - entry.getKey();
            if (map.containsKey(complement) && complement != entry.getKey()) {
                return true;
            }
            if (complement == entry.getKey() && entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

// Solution 2: similar to Two Sum II, use sorted array + two pointers
class TwoSum {
    private List<Integer> nums;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        this.nums = new ArrayList<Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Collections.sort(nums);
        int start = 0, end = nums.size() - 1;
        while (start < end) {
            if (nums.get(start) + nums.get(end) == value) {
                return true;
            }
            else if (nums.get(start) + nums.get(end) < value) {
                start++;
            }
            else {
                end--;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
