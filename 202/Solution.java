// Solution 1: Recursion + Traversal (HashSet should be a global variable in the class) --> can also use iteration
// Note: The difficulty of this question is to analyze the complexity!!!
// Time complexity: O(logn)
// Space complexity: O(logn) 
class Solution {
    HashSet<Integer> visited = new HashSet<>();
    public boolean isHappy(int n) {
        // base case
        if (squareSum(n) == 1) {
            return true;
        }
        // recursion rule: detect loop
        else if (!visited.add(n)) {
            return false;
        }
        else {
            return isHappy(squareSum(n));
        }
    }
    
    private int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }
}

// Solution 2: optimize space +  Similar to: LinkedList Cycle Detection
// Time complexity: O(logn)
// Space complexity: O(1)
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = squareSum(n);
        while (fast != 1 && slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        return fast == 1;
    }
    
    private int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }
}
