class MyQueue {
  Deque<Integer> stack1 = new ArrayDeque<>(); // base
  Deque<Integer> stack2 = new ArrayDeque<>(); // temp

  // Push element x to the back of queue.
  public void push(int x) {
    stack1.push(x);
  }

  // Removes the element from in front of queue.
  public void pop() {
    while (stack1.size() > 1) {
      stack2.push(stack1.pop());
    }
    stack1.clear();
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }
  }

  // Get the front element.
  public int peek() {
    while (stack1.size() > 1) {
      stack2.push(stack1.pop());
    }
    int ret = stack1.peek();
    stack2.push(stack1.pop());
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }
    return ret;
  }

  // Return whether the queue is empty.
  public boolean empty() {
    return stack1.isEmpty();
  }
}
