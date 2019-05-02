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
<table>
   <tr>
      <td>Modifier and Type</td>
      <td>Method and Description</td>
   </tr>
   <tr>
      <td>boolean</td>
      <td>add(E e)</td>
   </tr>
   <tr>
      <td>Appends the specified element to the end of this list.</td>
   </tr>
   <tr>
      <td>void</td>
      <td>add(int index, E element)</td>
   </tr>
   <tr>
      <td>Inserts the specified element at the specified position in this list.</td>
   </tr>
   <tr>
      <td>boolean</td>
      <td>addAll(Collection<? extends E> c)</td>
   </tr>
   <tr>
      <td>Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's Iterator.</td>
   </tr>
   <tr>
      <td>boolean</td>
      <td>addAll(int index, Collection<? extends E> c)</td>
   </tr>
   <tr>
      <td>Inserts all of the elements in the specified collection into this list, starting at the specified position.</td>
   </tr>
   <tr>
      <td>void</td>
      <td>clear()</td>
   </tr>
   <tr>
      <td>Removes all of the elements from this list.</td>
   </tr>
   <tr>
      <td>Object</td>
      <td>clone()</td>
   </tr>
   <tr>
      <td>Returns a shallow copy of this ArrayList instance.</td>
   </tr>
   <tr>
      <td>boolean</td>
      <td>contains(Object o)</td>
   </tr>
   <tr>
      <td>Returns true if this list contains the specified element.</td>
   </tr>
   <tr>
      <td>void</td>
      <td>ensureCapacity(int minCapacity)</td>
   </tr>
   <tr>
      <td>Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.</td>
   </tr>
   <tr>
      <td>void</td>
      <td>forEach(Consumer<? super E> action)</td>
   </tr>
   <tr>
      <td>Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.</td>
   </tr>
   <tr>
      <td>E</td>
      <td>get(int index)</td>
   </tr>
   <tr>
      <td>Returns the element at the specified position in this list.</td>
   </tr>
   <tr>
      <td>int</td>
      <td>indexOf(Object o)</td>
   </tr>
   <tr>
      <td>Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.</td>
   </tr>
   <tr>
      <td>boolean</td>
      <td>isEmpty()</td>
   </tr>
   <tr>
      <td>Returns true if this list contains no elements.</td>
   </tr>
   <tr>
      <td>Iterator<E></td>
      <td>iterator()</td>
   </tr>
   <tr>
      <td>Returns an iterator over the elements in this list in proper sequence.</td>
   </tr>
   <tr>
      <td>int</td>
      <td>lastIndexOf(Object o)</td>
   </tr>
   <tr>
      <td>Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.</td>
   </tr>
   <tr>
      <td>ListIterator<E></td>
      <td>listIterator()</td>
   </tr>
   <tr>
      <td>Returns a list iterator over the elements in this list (in proper sequence).</td>
   </tr>
   <tr>
      <td>ListIterator<E></td>
      <td>listIterator(int index)</td>
   </tr>
   <tr>
      <td>Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.</td>
   </tr>
   <tr>
      <td>E</td>
      <td>remove(int index)</td>
   </tr>
   <tr>
      <td>Removes the element at the specified position in this list.</td>
   </tr>
   <tr>
      <td>boolean</td>
      <td>remove(Object o)</td>
   </tr>
   <tr>
      <td>Removes the first occurrence of the specified element from this list, if it is present.</td>
   </tr>
   <tr>
      <td>boolean</td>
      <td>removeAll(Collection<?> c)</td>
   </tr>
   <tr>
      <td>Removes from this list all of its elements that are contained in the specified collection.</td>
   </tr>
   <tr>
      <td>boolean</td>
      <td>removeIf(Predicate<? super E> filter)</td>
   </tr>
   <tr>
      <td>Removes all of the elements of this collection that satisfy the given predicate.</td>
   </tr>
   <tr>
      <td>protected void</td>
      <td>removeRange(int fromIndex, int toIndex)</td>
   </tr>
   <tr>
      <td>Removes from this list all of the elements whose index is between fromIndex, inclusive, and toIndex, exclusive.</td>
   </tr>
   <tr>
      <td>void</td>
      <td>replaceAll(UnaryOperator<E> operator)</td>
   </tr>
   <tr>
      <td>Replaces each element of this list with the result of applying the operator to that element.</td>
   </tr>
   <tr>
      <td>boolean</td>
      <td>retainAll(Collection<?> c)</td>
   </tr>
   <tr>
      <td>Retains only the elements in this list that are contained in the specified collection.</td>
   </tr>
   <tr>
      <td>E</td>
      <td>set(int index, E element)</td>
   </tr>
   <tr>
      <td>Replaces the element at the specified position in this list with the specified element.</td>
   </tr>
   <tr>
      <td>int</td>
      <td>size()</td>
   </tr>
   <tr>
      <td>Returns the number of elements in this list.</td>
   </tr>
   <tr>
      <td>void</td>
      <td>sort(Comparator<? super E> c)</td>
   </tr>
   <tr>
      <td>Sorts this list according to the order induced by the specified Comparator.</td>
   </tr>
   <tr>
      <td>Spliterator<E></td>
      <td>spliterator()</td>
   </tr>
   <tr>
      <td>Creates a late-binding and fail-fast Spliterator over the elements in this list.</td>
   </tr>
   <tr>
      <td>List<E></td>
      <td>subList(int fromIndex, int toIndex)</td>
   </tr>
   <tr>
      <td>Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.</td>
   </tr>
   <tr>
      <td>Object[]</td>
      <td>toArray()</td>
   </tr>
   <tr>
      <td>Returns an array containing all of the elements in this list in proper sequence (from first to last element).</td>
   </tr>
   <tr>
      <td><T> T[]</td>
      <td>toArray(T[] a)</td>
   </tr>
   <tr>
      <td>Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array.</td>
   </tr>
   <tr>
      <td>void</td>
      <td>trimToSize()</td>
   </tr>
   <tr>
      <td>Trims the capacity of this ArrayList instance to be the list's current size.</td>
   </tr>
</table>
