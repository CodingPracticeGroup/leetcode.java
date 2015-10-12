import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  private boolean longestValidParentheses_match(char left, char right) {
    if (left == '(' && right == ')') {
      return true;
    }
    return false;
  }

  public int longestValidParentheses(String s) {
    int lastValidStart = -1;

    lastValidStart = 0;
    int max = 0;
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (stack.isEmpty()) {
        if (c == '(') {
          stack.push(c);
        } else {
          lastValidStart = i + 1;
        }
      } else {
        if (longestValidParentheses_match(stack.peek(), c)) {
          stack.pop();
          if (stack.isEmpty()) {
            max = Math.max(max, i - lastValidStart + 1);
          }
        } else {
          stack.push(c);
        }
      }
    }

    lastValidStart = s.length() - 1;
    int max2 = 0;
    stack.clear();
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (stack.isEmpty()) {
        if (c == ')') {
          stack.push(c);
        } else {
          lastValidStart = i - 1;
        }
      } else {
        if (longestValidParentheses_match(c, stack.peek())) {
          stack.pop();
          if (stack.isEmpty()) {
            max2 = Math.max(max2, lastValidStart - i + 1);
          }
        } else {
          stack.push(c);
        }
      }
    }

    return Math.max(max, max2);
  }
}
