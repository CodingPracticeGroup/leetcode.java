class MinStack {
    private ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
    private ArrayDeque<Integer> minstack = new ArrayDeque<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if(minstack.isEmpty()){
            minstack.push(x);
        }
        else if(x <= minstack.peek()){
            minstack.push(x);
        }
    }

    public void pop() {
        if(stack.pop().equals(minstack.peek())){
            minstack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
