# Intuition
When we use ".." , we can exit the last directory we input. -> Last in First Out -> Stack
# Algorithm
- Get all the strings related to real operation by using .split("/")
- Then add the strings related to the simplest path into the stack:
  - If we meet "..": if the stack is not empty, pop the last directory. Otherwise, we stay in the origin directory without doing anything.
  - If we meet a string which is not "." or ", then we can conclude that this string is a name of a directory. Push the name into the stack.
- Return the simplified path:
  - If nothing contains in the stack. return "/"
  - If not, the result will be / XX NAME / XX NAME/ ...("/"+stack.pop()+res until the all the elements are poped out of the stack)
# Pseudocode
```Java
Input: String path
Output: String

// create a stack to store the order of directory
Stack<String>  stack = new Stack<>();

// find all the accessions in the path
String[] directory = path.split("/")

for (String d : directory)
  //讨论所有可能遇到的字符情况：“..”“.”" ""directory name"
  // pop the directory name which has already not been accessed
  // make sure pop when the stack is not empty!!!!!!!!!(老错)
  //不可以把两个if合并在一起写，逻辑会变
  if (d.equals("..")) then if (!s.isEmpty()) then d.pop()
  //push into vaild directory name
  else if (!d.equals(".") && !d.equals("")) then d.push(d)
//If no directory contains in stack  
if (stack.isEmpty()) return "/"
//If some vaild directory names contain in stack
String res = ""
while (!res.isEmpty()) then res = "/" + stack.pop() + res

return res
```
# Complexity
- Time complexity:O(n)
- Space complexity: O(n)
