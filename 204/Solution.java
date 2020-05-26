// Solution 1: (optimal solution)
// Time complexity: O(n * sqrt(n))
// Space complexity: O(n)
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        // check the number of primes from 2 to n - 1
        for (int i = 2; i < n; i++) {
            // if we find a prime (starts from 2)
            if (isPrime[i]) {
                count++;
                // any number(j * i) that is divisible by i is not a prime
                for (int j = 2; j * i < n; j++) {
                    isPrime[j * i] = false;
                }
            } 
        }

        return count;
    }
}
// Solution 2: (exceed time limit)
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isPrime(int x) {
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
