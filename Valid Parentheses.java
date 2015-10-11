public class Solution {
  private boolean isValid_match(char left, char right) {
    if (left == '(' && right == ')') {
      return true;
    }
    if (left == '[' && right == ']') {
      return true;
    }
    if (left == '{' && right == '}') {
      return true;
    }
    return false;
  }

  public boolean isValid(String s) {
    char[] c = s.toCharArray();
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < c.length; i++) {
      if (stack.isEmpty()) {
        stack.push(c[i]);
      } else {
        if (isValid_match(stack.peek(), c[i])) {
          stack.pop();
        } else {
          stack.push(c[i]);
        }
      }
    }
    return stack.isEmpty();
  }
}
