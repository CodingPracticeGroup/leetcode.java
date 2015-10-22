class MyStack {
  Queue<Integer> q1 = new ArrayDeque<>(); // base
  Queue<Integer> q2 = new ArrayDeque<>(); // temp

  // Push element x onto stack.
  public void push(int x) {
    q1.offer(x);
  }

  // Removes the element on top of the stack.
  public void pop() {
    while (q1.size() > 1) {
      q2.offer(q1.poll());
    }
    q1.clear();
    while (!q2.isEmpty()) {
      q1.offer(q2.poll());
    }
  }

  // Get the top element.
  public int top() {
    while (q1.size() > 1) {
      q2.offer(q1.poll());
    }
    int ret = q1.peek();
    q2.offer(q1.poll());
    while (!q2.isEmpty()) {
      q1.offer(q2.poll());
    }
    return ret;
  }

  // Return whether the stack is empty.
  public boolean empty() {
    return q1.isEmpty();
  }
}
