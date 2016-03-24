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
-------------------------------
class MyStack {
  Queue<Integer> q1 = new LinkedList<>();
  Queue<Integer> q2 = new LinkedList<>();

  // Push element x onto stack.
  public void push(int x) {
    q1.offer(x);
  }

  // Removes the element on top of the stack.
  public void pop() {
    while (q1.size() > 1) {
      q2.offer(q1.poll());
    }
    q1.poll();// the last one
    while (!q2.isEmpty()) {
      q1.offer(q2.poll());
    }
  }

  // Get the top element.
  public int top() {
    while (q1.size() > 1) {
      q2.offer(q1.poll());
    }
    int ret = q1.poll();// the last one
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
