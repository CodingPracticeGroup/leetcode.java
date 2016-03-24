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
-----------------
class MinStack {
  LinkedList<Integer> stack = new LinkedList<>();
  LinkedList<Integer> minstack = new LinkedList<>();

  public void push(int x) {
    if (!stack.isEmpty()) {
      if (minstack.peek() >= x) {
        minstack.push(x);
      }
    } else {
      minstack.push(x);
    }
    stack.push(x);
  }

  public void pop() {
    if (!stack.isEmpty()) {
      if (stack.peek().equals(minstack.peek())) { // 这个是必须equals，因为两边都是obj；如果一边是obj一遍是primitive，是可以==比较的
        minstack.pop();
      }
      stack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minstack.peek();
  }
}
