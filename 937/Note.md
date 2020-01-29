# Comparator Interface
- A comparison function, which imposes a total ordering on some collection of objects. 
Comparators can be passed to a sort method (such as Collections.sort or Arrays.sort) to allow precise control over the sort order. Comparators can also be used to control the order of certain data structures (such as sorted sets or sorted maps), or to provide an ordering for collections of objects that don't have a **natural ordering**.
```javascript
int compare(Object obj1, Object obj2)
```
obj1 and obj2 are the objects to be compared. This method returns zero if the objects are equal. It returns a positive value if obj1 is greater than obj2. Otherwise, a negative value is returned.
# ASCII numbers v.s. letters
- numbers 0-9: 48-57
- letters A-Z: 65-90
- letters a-z: 97-122
