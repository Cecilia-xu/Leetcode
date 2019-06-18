# Algorithm 1
Make the elements stored in the stack keep the order of queue, which means the first element pushed into the queue should be the last element of the stack.
- create 2 stacks: 1 stack - implement queue/ 1 stack- store elements temporarily
- If we want to push any element, pop all the elements from the 1st stack to another stack at first. And then, push this element into the first stack and make it become the first element in the 1st stack. In the end, push all the elements from the 2nd stack to the 1st stack.
- If we want to pop() or peek() or empty(), just use these methods on the 1st stack because the 1st stack keep the order of pushing. Therefore, the last element in the 1st stack is the first element we pushed into the queue Also, the ast stack contains all the elements we pushed into.
# Algorithm 2
Make two stacks store the element. The 2nd stack will be used when we need to pop something. This approach is similar to the first one. However, we do not need to push all the elemnets back into 1st stack every time. We just need to do that if we need to.
- create 2 stacks
- If we want to push something, just push them into the 1st stack.
- If we want to pop something and the 2nd stack is empty, pop all the elements into the 2nd stack. Then, the last element pushed into the 2nd stack is what we need to pop.
- If we want to pop something and the 2nd stack is not empty, pop the last element from the 2nd stack since it is the 2nd element we pushed into the queue.
- If we want to peek something, it is similar to pop operation. Just use peek() on the 2nd stack.
- If we want to implement empty(), do it on both 1st stack and 2nd stack. This is because all the elements are stored in those two stacks.
