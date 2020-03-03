// Two sum: data structure design
// Solution 1: similar to twoSum, use hashmap
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
