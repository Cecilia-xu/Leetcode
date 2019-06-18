# Algorithm 1:
Make the elements stored in the stack keep the order of queue, which means the first element pushed into the queue should be the last element of the stack.
- create 2 stacks: 1 stack - implement queue/ 1 stack- store elements temporarily
- If we want to push any element, pop all the elements from the 1st stack to another stack at first. And then, push this element into the first stack and make it become the first element in the 1st stack. In the end, push all the elements from the 2nd stack to the 1st stack.
