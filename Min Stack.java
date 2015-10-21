class MinStack {
  Deque<Integer> stack = new ArrayDeque<>();
  Deque<Integer> minstack = new ArrayDeque<>();

  public void push(int x) {
    stack.push(x);
    if (minstack.isEmpty()) {
      minstack.push(x);
    } else {
      if (x <= minstack.peek()) {
        minstack.push(x);
      }
    }
  }

  public void pop() {
    if (stack.peek().equals(minstack.peek())) {
      minstack.pop();
    }
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minstack.peek();
  }
}
