# My solution 1: two pinters
> Time complexity: O(n) <br>
Space complexity: O(1)
```Java
class Solution {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            swap(s,start ++,end --);
        }
    }
    
    private void swap(char[] s, int start, int end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }
}
```
