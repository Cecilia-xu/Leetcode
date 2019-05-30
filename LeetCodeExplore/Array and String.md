# Array and String
## 1. Array Operations
```Java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
    
        // 1. Initialize
        int[] a0 = new int[5];
        int[] a1 = {1, 2, 3};
        
        // 2. Get Length
        System.out.println("The size of a1 is: " + a1.length);
        
        // 3. Access Element
        System.out.println("The first element is: " + a1[0]);
        
        // 4. Iterate all Elements
        System.out.print("[Version 1] The contents of a1 are:");
        for (int i = 0; i < a1.length; ++i) {
            System.out.print(" " + a1[i]);
        }
        System.out.println();
        
        System.out.print("[Version 2] The contents of a1 are:");
        for (int item: a1) {
            System.out.print(" " + item);
        }
        System.out.println();
        
        // 5. Modify Element
        a1[0] = 4;
        
        // ***6. Sort
        Arrays.sort(a1);
    }
}
```
## 2. ArrayList Operations
```Java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // 1. initialize
        List<Integer> v0 = new ArrayList<>();
        List<Integer> v1;                           // v1 == null
        
        // ***2. cast an array to a vector
        Integer[] a = {0, 1, 2, 3, 4};
        v1 = new ArrayList<>(Arrays.asList(a));
        
        // ***3. make a copy(difference between tqo approaches)
        List<Integer> v2 = v1;                      // another reference to v1
        List<Integer> v3 = new ArrayList<>(v1);     // make an actual copy of v1
        
        // 3. get length
        System.out.println("The size of v1 is: " + v1.size());
        
        // 4. access element
        System.out.println("The first element in v1 is: " + v1.get(0));
        
        // 5. iterate the vector
        System.out.print("[Version 1] The contents of v1 are:");
        for (int i = 0; i < v1.size(); ++i) {
            System.out.print(" " + v1.get(i));
        }
        System.out.println();
        
        System.out.print("[Version 2] The contents of v1 are:");
        for (int item : v1) {
            System.out.print(" " + item);
        }
        System.out.println();
        
        // 6. modify element
        v2.set(0, 5);       //* modify v2 will actually modify v1
        System.out.println("The first element in v1 is: " + v1.get(0));
        v3.set(0, -1);
        System.out.println("The first element in v1 is: " + v1.get(0));
        
        // ***7. sort
        Collections.sort(v1);
        
        // 8. add new element at the end of the vector
        v1.add(-1);
        v1.add(1, 6);
        
        // 9. delete the last element
        v1.remove(v1.size() - 1);
    }
}
```
## 3. 2D Array
```Java
// "static void main" must be defined in a public class.
public class Main {
    private static void printArray(int[][] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; a[i] != null && j < a[i].length; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("Example I:");
        int[][] a = new int[2][5];
        printArray(a);
        System.out.println("Example II:");
        int[][] b = new int[2][];
        printArray(b);
        System.out.println("Example III:");
        b[0] = new int[3];
        b[1] = new int[5];
        printArray(b);
    }
}
```
#### Result
```
Example I:
[I@7d4991ad
[I@28d93b30
0 0 0 0 0 
0 0 0 0 0 
Example II:
null
null


Example III:
[I@1b6d3586
[I@4554617c
0 0 0 
0 0 0 0 0 
```
#### Principles
In Java, a two-dimensional array is actually one-dimensional array which contains M elelments, each of which is an array of N integers. (N can be different in anyone in these M elements)
## 4. Introduction to String (focus on the differences between array and string)
- Compare function <br>
Since Java does not support operator overloading, we may not use "==" to compare two strings. When we use "==", it actually compares whether these two objects are the same object.
```Java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // initialize
        String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");
        
        // compare using '=='
        System.out.println("Compared by '==':");
        
        // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
        
        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));
        
        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));
        
        // compare using 'equals'
        System.out.println("Compared by 'equals':");
        // all true since contents of all the strings are "Hello world"
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
        System.out.println("s1 and s2: " + s1.equals(s2));
        System.out.println("s1 and s3: " + s1.equals(s3));
        
        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo':");
        // all true since ASCII values of all the strings are equal and thus all the CompareTo methods return 0
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));
    }
}
```
Other Reference: [Java | ==, equals(), compareTo(), equalsIgnoreCase() and compare()](https://www.geeksforgeeks.org/java-equals-compareto-equalsignorecase-and-compare/)
>  Conclusion: 
    >> 1. ==: compare the object
    2. equals: compare the content of string 
    3. compareTo: compare the ASCII value of the string 
    4. equalsIgnoreCase: similar to equals, but ignore the case 
    5. compare: should use Collator class which is in java.text packages; can define our own custom comparison rules
