class MinStack {
  Deque<Integer> stack = new ArrayDeque<>();
  Deque<Integer> minStack = new ArrayDeque<>();

  public void push(int x) {
    stack.push(x);
    if (minStack.isEmpty()) {
      minStack.push(x);
    } else if (x <= minStack.peek()) {
      minStack.push(x);
    }
  }

  public void pop() {
    if (stack.peek().equals(minStack.peek())) {
      minStack.pop();
    }
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
