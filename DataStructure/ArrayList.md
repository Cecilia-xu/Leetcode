# ArrayList
## Benifits
1. Supports random access
2. Size maintained automatically
3. Insert and delete handled automatically
## Constructors
1. public ArrayList(int initialCapacity)
2. public ArrayList()
3. public ArrayList(Collection<? extends E> c):copy constructor/Size is 110% of original ArrayList<br>
3.1 New ArrayList contains copies of references, not elements<Shallow copy><br>
3.2 Similar to System.arraycopy<br>
3.3 Operates in O(n) time
## Methods
Reference：https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
## Time Complexity(worst case)
1. Add: add(element) - O(n)
2. Delete: remove(Object element/int index) - O(n)
3. Search: get(index) - O(1) / contains(element)/indexOf(element) - O(n)
4. Modify: set(index,element) - O(1)
