# Algorithm
- Find which bit will generate carry: using & since two 1 will generate a carry
``` Java
3    =>  011 
2    =>  010 
3(011) & 2(010)  =>  010
```
In the example above, we found that the 1th  bit can generate a carry
- Find which bit can be added directly: using XOR since 0 and 1 exist in the same bit and 0 + 1 = 1  will be the result after adding
``` Java
3    =>  011 
2    =>  010 
3(011) ^ 2(010)  =>  001
```
- 
