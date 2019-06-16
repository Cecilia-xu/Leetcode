# Solution 1: Use substring method
> Time complexity: O(nm) (m = l2,因为substring的时间复杂度是O(1)，详见普林斯顿算法第四版)<br> Space complexity: O(1）
``` Java
class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l2 > l1) {
            return -1;
        }
        if (l2 == 0) {
            return 0;
        }
        for (int i = 0; i <= l1 - l2; i ++) {
            if (haystack.substring(i, i + l2).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
```
Note:<br>
1. How to use structural thinking! No duplication ! No omission!
2. Logic operatior: == not =！
3. 注意这里的for循环的范围一定是到l1-l2,还必须得包括这个数！因为如果超过这个范围都不可能取到完整的l2长度的字符，所以根本不用查！
4. 实际面试不一定可以用
# Solution 2: Use indexOf method
```Java
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle。length == 0) {
            return 0;
        }

        return haystack.indexOf(needle);
    }
}
```
Note：<br>
1. 这种做法更作弊，实际不可以用，在这里写是为了提醒自己这个题本质是要求实现indexOf（）
# Solution 3：Brute-force method
> Time complexity:O()<br> Space complexity: O()
```Java
class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        for (int i = 0; i <= l1 - l2; i ++) {
            int j;
            for (j = 0; j < l2; j ++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            // If all characters in needle are checked without any mistake, 
            // which means we find this substring correctly, return i.
            if (j == l2) return i;
        }
        //Otherwise, return -1.
        return -1;
    }
}
```
Reference: Algorithms 4th Chapter 5 P760
