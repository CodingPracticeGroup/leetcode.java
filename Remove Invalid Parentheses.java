public class Solution {
  private boolean removeInvalidParentheses_check(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(i);
      } else if (c == ')') {
        if (stack.isEmpty()) {
          return false;
        } else {
          stack.pop();
        }
      }
    }
    return stack.isEmpty();
  }

  public List<String> removeInvalidParentheses(String s) {
    Set<String> ret = new HashSet<>();
    Set<String> q = new HashSet<>();
    q.add(s);
    while (ret.isEmpty() && !q.isEmpty()) {
      Set<String> q_ = new HashSet<>();
      for (String ss : q) {
        if (removeInvalidParentheses_check(ss)) {
          ret.add(ss);
        } else {
          for (int j = 0; j < ss.length(); j++) {
            char cc = ss.charAt(j);
            if (cc == '(' || cc == ')') {
              q_.add(ss.substring(0, j) + ss.substring(j + 1));
            }
          }
        }
      }
      q = q_;
    }
    return new ArrayList<String>(ret);
  }
}
------------
public class Solution {
  private boolean check(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        count++;
      } else if (s.charAt(i) == ')') {
        count--;
        if (count < 0) {
          return false;
        }
      }
    }
    return count == 0;
  }

  public List<String> removeInvalidParentheses(String s) {
    List<String> ret = new ArrayList<>();
    Set<String> queue = new HashSet<>();
    queue.add(s);
    while (!queue.isEmpty()) {
      Set<String> q2 = new HashSet<>();
      for (String str : queue) { // level bfs
        if (check(str)) {
          ret.add(str);
        } else {
          for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')') {
              q2.add(str.substring(0, i) + str.substring(i + 1, str.length()));
            }
          }
        }
      }
      if (!ret.isEmpty()) {
        return ret;
      }
      queue = q2;
    }
    return ret;
  }
}
