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
