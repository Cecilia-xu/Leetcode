# Algorithm
- Find which bit will generate carry: using & since two 1 will generate a carry
``` Java
3    =>  011 
2    =>  010 
3(011) & 2(010)  =>  010
```
In the example above, we found that the 1th  bit can generate a carry.
- Make sure the number gets added at the right spot: Left shift the previous result by one
``` Java
010 <<1   => 100
```
- Find which bit can be added directly: using XOR since 0 and 1 exist in the same bit and 0 + 1 = 1  will be the result after adding
``` Java
3    =>  011 
2    =>  010 
3(011) ^ 2(010)  =>  001
```
- Use XOR: If there is no 1 exist on the same bit, it will be the final answer (since there is no more carries)
``` Java
100 ^ 001 => 101
```
- Notice that the previous result may not be the final answer because when two 1s exist on the same spot. XOR is not always similar to addition operation.
Therefore, we need to use & to make sure no more 1s exist on the same spot.
``` Java
100 & 001 => 000
```
In the example above, no more carries exists so we get the final answer. If not, we have to repeat the steps above until no carry exists.
