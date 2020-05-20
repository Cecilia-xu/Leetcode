// My solution: stack + hashmap
// Intuition: Look back and check whether the top of the stack is smaller -> maintain a monotonic increasing stack
class StockSpanner {
    public Stack<Integer> stack;
    public HashMap<Integer, Integer> priceToSpan;
    public StockSpanner() {
        this.stack = new Stack<>();
        this.priceToSpan = new HashMap<>();
    }
    
    public int next(int price) {
        int span = 1;
        //******make sure is not empty when stack.peek() or stack.pop() 
        while (!stack.isEmpty() && price >= stack.peek()) {
            int pre = stack.pop();
            span += priceToSpan.get(pre);
            priceToSpan.remove(pre);
        }
        stack.push(price);
        priceToSpan.put(price, span);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
 // Solution by others: use int array to save space
 class StockSpanner {
    public Stack<int[]> stack;
    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
