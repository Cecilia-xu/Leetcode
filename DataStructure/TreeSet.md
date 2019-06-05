# Set
- An collection of objects in which duplicate values cannot be stored
- Implemented by HashSet, LinkedHashSet or TreeSet
# TreeSet
- Implementations of the <strong>SortedSet</strong> interface in Java that uses a <strong>Tree</strong> for storage
- Objects in a TreeSet are stored in a sorted and ascending order.
- TreeSet does not allow to insert Heterogeneous objects
- Serves choice for storing large amounts of sorted information which are supposed to be accessed quickly because of its faster access and retrieval time
- TreeSet is basically implementation of a self-balancing binary search tree. Therefore operations like add, remove and search take O(Log n) time. And operations like printing n elements in sorted order takes O(n) time.
# Constructors
1. TreeSet t = new TreeSet();<br>
This will create empty TreeSet object in which elements will get stored in default natural sorting order.
2. TreeSet t = new TreeSet(Comparator comp);<br>
This constructor is used when external specification of sorting order of elements is needed.
3. TreeSet t = new TreeSet(Collection col); <br>
This constructor is used when any conversion is needed from any Collection object to TreeSet object.
4. TreeSet t = new TreeSet(SortedSet s);<br>
This constructor is used to convert SortedSet object to TreeSet Object.
# Methods
1. void add(Object o): This method will add specified element according to some sorting order in TreeSet. Duplicate entires will not get added.
2. boolean addAll(Collection c): This method will add all elements of specified Collection to the set. Elements in Collection should be homogeneous otherwise ClassCastException will be thrown. Duplicate Entries of Collection will not be added to TreeSet.
3. void clear(): This method will remove all the elements.
boolean contains(Object o): This method will return true if given element is present in TreeSet else it will return false.
4. Object first(): This method will return first element in TreeSet if TreeSet is not null else it will throw NoSuchElementException.
5. Object last(): This method will return last element in TreeSet if TreeSet is not null else it will throw NoSuchElementException.
6. SortedSet headSet(Object toElement): This method will return elements of TreeSet which are less than the specified element.
7. SortedSet tailSet(Object fromElement): This method will return elements of TreeSet which are greater than or equal to the specified element.
8. SortedSet subSet(Object fromElement, Object toElement): This method will return elements ranging from fromElement to toElement. fromElement is inclusive and toElement is exclusive.
9. boolean isEmpty(): This method is used to return true if this set contains no elements or is empty and false for the opposite case.
10. Object clone(): The method is used to return a shallow copy of the set, which is just a simple copied set.
11. int size(): This method is used to return the size of the set or the number of elements present in the set.
12. boolean remove(Object o): This method is used to return a specific element from the set.
13. Iterator iterator(): Returns an iterator for iterating over the elements of the set.
14. Comparator comparator(): This method will return Comparator used to sort elements in TreeSet or it will return null if default natural sorting order is used.
15. ceiling​(E e): This method returns the least element in this set greater than or equal to the given element, or null if there is no such element.
16. descendingIterator​(): This method returns an iterator over the elements in this set in descending order.
17. descendingSet​(): This method returns a reverse order view of the elements contained in this set.
18. floor​(E e): This method returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
19. higher​(E e): This method returns the least element in this set strictly greater than the given element, or null if there is no such element.
20. lower​(E e): This method returns the greatest element in this set strictly less than the given element, or null if there is no such element.
21. pollFirst​(): This method retrieves and removes the first (lowest) element, or returns null if this set is empty.
22. pollLast​(): This method retrieves and removes the last (highest) element, or returns null if this set is empty.
23. spliterator​(): This method creates a late-binding and fail-fast Spliterator over the elements in this set.
