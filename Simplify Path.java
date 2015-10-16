public class Solution {
  public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    String[] pieces = path.split("/");
    for (String s : pieces) {
      if (s.equals("")) {

      } else if (s.equals(".")) {

      } else if (s.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(s);
      }
    }
    if (stack.isEmpty()) {
      return "/";
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
      sb.insert(0, "/");
    }
    return sb.toString();
  }
}
