class MyQueue {
  Deque<Integer> stack_tmp = new ArrayDeque<>();
  Deque<Integer> stack_last = new ArrayDeque<>();

  // Push element x to the back of queue.
  public void push(int x) {
    stack_last.push(x);
  }

  // Removes the element from in front of queue.
  public void pop() {
    while (stack_last.size() > 1) {
      stack_tmp.push(stack_last.pop());
    }
    stack_last.clear();
    while (!stack_tmp.isEmpty()) {
      stack_last.push(stack_tmp.pop());
    }
  }

  // Get the front element.
  public int peek() {
    while (stack_last.size() > 1) {
      stack_tmp.push(stack_last.pop());
    }
    int ret = stack_last.peek();
    while (!stack_tmp.isEmpty()) {
      stack_last.push(stack_tmp.pop());
    }
    return ret;
  }

  // Return whether the queue is empty.
  public boolean empty() {
    return stack_last.isEmpty();
  }
}
-------------
class MyQueue {
  Deque<Integer> stack1 = new LinkedList<>();
  Deque<Integer> stack2 = new LinkedList<>();

  // Push element x to the back of queue.
  public void push(int x) {
    stack1.push(x);
  }

  // Removes the element from in front of queue.
  public void pop() {
    while (stack1.size() > 1) {
      stack2.push(stack1.pop());
    }
    stack1.pop();
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }
  }

  // Get the front element.
  public int peek() {
    while (stack1.size() > 1) {
      stack2.push(stack1.pop());
    }
    int ret = stack1.pop();
    stack2.push(ret);
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
