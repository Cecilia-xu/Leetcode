# Intuition
When we use ".." , we can exit the last directory we input. -> Last in First Out -> Stack
# Algorithm
# Pseudocode
```
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
if (stack.isEmpty) return "/"
//If some vaild directory names contain in stack
String res = ""
while (!res.isEmpty()) then res = "/" + stack.pop() + res

return res
```
# Complexity
- Time complexity:O(n)
- Space complexity: O(n)
