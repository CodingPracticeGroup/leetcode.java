public class Solution {
  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 0; i < tokens.length; i++) {
      if (!stack.isEmpty() && tokens[i].equals("+")) {
        int op2 = stack.pop();
        int op1 = stack.pop();
        stack.push(op1 + op2);
      } else if (!stack.isEmpty() && tokens[i].equals("-")) {
        int op2 = stack.pop();
        int op1 = stack.pop();
        stack.push(op1 - op2);
      } else if (!stack.isEmpty() && tokens[i].equals("*")) {
        int op2 = stack.pop();
        int op1 = stack.pop();
        stack.push(op1 * op2);
      } else if (!stack.isEmpty() && tokens[i].equals("/")) {
        int op2 = stack.pop();
        int op1 = stack.pop();
        stack.push(op1 / op2);
      } else {
        stack.push(Integer.valueOf(tokens[i]));
      }
    }
    return stack.pop();
  }
}
----------------
public class Solution {
  public int evalRPN(String[] a) {
    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 0; i < a.length; i++) {
      switch (a[i]) {
        case "+":
          stack.push(stack.pop() + stack.pop());
          break;

        case "-":
          stack.push(-stack.pop() + stack.pop());
          break;

        case "*":
          stack.push(stack.pop() * stack.pop());
          break;

        case "/":
          int n1 = stack.pop(), n2 = stack.pop();
          stack.push(n2 / n1);
          break;

        default:
          stack.push(Integer.parseInt(a[i]));
      }
    }

    return stack.pop();
  }
}
----------------
public class Solution {
  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < tokens.length; i++) {
      if (tokens[i].equals("+")) {
        int d2 = stack.pollLast();
        int d1 = stack.pollLast();
        stack.offerLast(d1 + d2);
      } else if (tokens[i].equals("-")) {
        int d2 = stack.pollLast();
        int d1 = stack.pollLast();
        stack.offerLast(d1 - d2);
      } else if (tokens[i].equals("*")) {
        int d2 = stack.pollLast();
        int d1 = stack.pollLast();
        stack.offerLast(d1 * d2);
      } else if (tokens[i].equals("/")) {
        int d2 = stack.pollLast();
        int d1 = stack.pollLast();
        stack.offerLast(d1 / d2);
      } else {
        stack.offerLast(Integer.parseInt(tokens[i]));
      }
    }
    return stack.poll();
  }
}
