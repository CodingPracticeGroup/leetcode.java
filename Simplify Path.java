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
-----------
public class Solution {
  public String simplifyPath(String path) {
    String[] strs = path.split("/");
    // String [] strs = path.replaceFirst("^/", "").split("/");
    Deque<String> stack = new ArrayDeque<>();
    for (String s : strs) {
      if (s.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pollLast();
        }
      } else if (!s.equals(".") && !s.equals("")) {
        stack.offerLast(s);
      }
    }
    if (stack.isEmpty()) {
      return "/";
    }
    StringBuilder sb = new StringBuilder();
    for (String s : stack) {
      sb.append("/");
      sb.append(s);
    }
    return sb.toString();
  }
}
--------------------
public class Solution {
  public String simplifyPath(String path) {
    Deque<String> stack = new LinkedList<>();
    Set<String> skip = new HashSet<>(Arrays.asList(".", "")); // hit/miss
    for (String dir : path.split("/")) {
      if (dir.equals("..") && !stack.isEmpty())
        stack.pop();
      else if (!skip.contains(dir))
        stack.push(dir);
    }
    String res = "";
    for (String dir : stack)
      res = "/" + dir + res;
    return res.isEmpty() ? "/" : res;
  }
}
