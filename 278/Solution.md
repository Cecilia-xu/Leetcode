# My solution
``` Java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid; 
            }
            if (!isBadVersion(mid)) {
                start = mid + 1;
            }
        }
        return start;
    }
}
```
Note: 
1. If we need to use any method that will return a boolean value, we have to figure out the meaning of this method first. It is important to know the cases where the method will return true. For example, the element is bad when the isBadVersion method returns ture.
2. You do not need to think about when no first bad verion exists because in this question there must exist one.
