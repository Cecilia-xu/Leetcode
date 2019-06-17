# Intuition
We found that we always compute with the last number we input when meeting an operator -> Last in First Out -> Stack
# Algorithm
> What I am thinking first is to use the operator and compute by using the last number with the result we have got(Pop one number each time). However, it is hard to compute the first result since we have to use two different numbers instead of one number. Therefore, we should consider another way to solve this problem without poping just one number.
- Create a stack and make sure the last two numbers are what we should use if we meet a specific operator.
    - If these two numbers are not computed yet, then the last two of them can be used in the first computation.
    - When we get an anser, push it back.
    - Therefore, whenever we need to compute, we can use the current result and the last number immediately.
# Complexity
- Time complexity: O(n) (Traverse the array once)
- Space complexity: O(n) (The stack can be at most O(n/2). n is the size of array)
