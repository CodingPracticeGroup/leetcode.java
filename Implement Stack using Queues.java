class MyStack {
  private Deque<Integer> q1 = new ArrayDeque<>();
  private Deque<Integer> q2 = new ArrayDeque<>();

  // Push element x onto stack.
  public void push(int x) {
    q1.offer(x);
  }

  // Removes the element on top of the stack.
  public void pop() {
    int count = q1.size();
    for (int i = 1; i < count; i++) {
      q2.offer(q1.poll());
    }
    q1.poll();
    while (!q2.isEmpty()) {
      q1.offer(q2.poll());
    }
  }

  // Get the top element.
  public int top() {
    int count = q1.size();
    for (int i = 1; i < count; i++) {
      q2.offer(q1.poll());
    }
    int ret = q1.poll();
    q2.offer(ret);
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
