public class Solution {
  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
        stack.pop();
      } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
        stack.pop();
      } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}
