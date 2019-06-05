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
