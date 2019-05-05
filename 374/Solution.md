# Solution 1
```Java
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        for (int i = 1; i < n; i ++) {
            if (guess(i) == 0) {
                return i;
            }
        }
        return n;
    }
}
```
# Solution 2
```Java
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int medium = low + (high - low) / 2;
            int result = guess(medium);
            if (result == 0) {
                return medium;
            }
            else {
                if (result > 0) {
                    low = medium + 1;
                }
                else {
                    high = medium - 1;
                }
            }
        }
        return -1;
    }
}
```
Note: binary search形成模板，low，high，while条件，medium，随着区间不同更新low/high
