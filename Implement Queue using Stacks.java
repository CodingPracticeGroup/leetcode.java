class MyQueue {
  Deque<Integer> s1 = new ArrayDeque<>();
  Deque<Integer> s2 = new ArrayDeque<>();

  // Push element x to the back of queue.
  public void push(int x) {
    s1.push(x);
  }

  // Removes the element from in front of queue.
  public void pop() {
    int count = s1.size();
    for (int i = 1; i < count; i++) {
      s2.push(s1.pop());
    }
    s1.pop();
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
  }

  // Get the front element.
  public int peek() {
    int count = s1.size();
    for (int i = 1; i < count; i++) {
      s2.push(s1.pop());
    }
    int ret = s1.peek();
    s2.push(s1.pop());
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
    return ret;
  }

  // Return whether the queue is empty.
  public boolean empty() {
    return s1.isEmpty();
  }
}
