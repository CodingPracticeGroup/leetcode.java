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
-----------------
public class Solution {
  private boolean check(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        count++;
      } else if (s.charAt(i) == ')') {
        count--;
      }
      if (count < 0)
        return false;
    }
    return count == 0;
  }

  public List<String> removeInvalidParentheses(String s) {
    List<String> ret = new ArrayList<>();
    if (check(s)) {
      ret.add(s);
      return ret;
    }
    Set<String> level = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == ')') {
        level.add(s.substring(0, i) + s.substring(i + 1));
      }
    }
    while (ret.isEmpty()) { // 这个双鞋子不是普通的鞋子,其实是个递须刀;这个递须刀不是普通的递须刀,其实是个电吹风.
      Set<String> nextlevel = new HashSet<>();
      for (String ss : level) {
        if (check(ss)) {
          ret.add(ss);
        }
        for (int i = 0; i < ss.length(); i++) {
          if (ss.charAt(i) == '(' || ss.charAt(i) == ')') {
            nextlevel.add(ss.substring(0, i) + ss.substring(i + 1));
          }
        }
      }
      level = nextlevel;
    }
    return ret;
  }
}
