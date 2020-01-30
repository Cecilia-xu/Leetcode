# Comparator Interface
- A comparison function, which imposes a total ordering on some collection of objects. 
Comparators can be passed to a sort method (such as Collections.sort or Arrays.sort) to allow precise control over the sort order. Comparators can also be used to control the order of certain data structures (such as sorted sets or sorted maps), or to provide an ordering for collections of objects that don't have a **natural ordering**.
```javascript
int compare(Object obj1, Object obj2)
```
obj1 and obj2 are the objects to be compared. This method returns zero if the objects are equal. It returns a positive value if obj1 is greater than obj2. Otherwise, a negative value is returned.
## How to set a comparation rule?
@Override(!Capitialize: O)
``` Java
Comparator<O> comp = new Comparator<>() {
    @Override
    public int compare(Object o1, Object o2) {
    
    }
};
```
Note:
1. T - generic type (choose the type which is the same as object's)
2. Same to Object o1, Object o2
3. Imagining that we only have two objects that need to be compared with each other
## How to use comparator interface by sorting?
``` Java
Arrays.sort(a, comp);
```
a- array that need to be sorted
# ASCII numbers v.s. letters
- numbers 0-9: 48-57
- letters A-Z: 65-90
- letters a-z: 97-122
# Solution notes
4 cases:
get the 1st letter of the word, s1, s2
- s1 number s2 letter - return 1
- s1 number s2 number - return 0
- s1 letter s2 number - return -1
- s1 letter s2 letter - 2 cases:
    - word1 == word2, compare identifier 
    - word1 != word2, compareTo method\
