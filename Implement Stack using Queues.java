class MyStack {
  Deque<Integer> queue = new ArrayDeque<>();
  Deque<Integer> queue_tmp = new ArrayDeque<>();

  // Push element x onto stack.
  public void push(int x) {
    queue.offer(x);
  }

  // Removes the element on top of the stack.
  public void pop() {
    while (queue.size() > 1) {
      queue_tmp.offer(queue.poll());
    }
    queue.clear();
    while (!queue_tmp.isEmpty()) {
      queue.offer(queue_tmp.poll());
    }
  }

  // Get the top element.
  public int top() {
    while (queue.size() > 1) {
      queue_tmp.offer(queue.poll());
    }
    int ret = queue.peek();
    queue_tmp.offer(queue.poll());
    while (!queue_tmp.isEmpty()) {
      queue.offer(queue_tmp.poll());
    }
    return ret;
  }

  // Return whether the stack is empty.
  public boolean empty() {
    return queue.isEmpty();
  }
}
