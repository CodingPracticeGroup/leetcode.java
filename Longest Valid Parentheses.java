public class Solution {
  public int longestValidParentheses(String s) {
    int max = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    int dp[] = new int[s.length()]; // the start idx of current round
    Arrays.fill(dp, -1);
    int i = 0;
    for (; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        dp[i] = i; // start idx
        stack.push(i);
        break;
      }
    }
    if (i == s.length()) {
      return max;
    }
    for (i++; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        if (i - 1 > 0 && s.charAt(i - 1) == ')' && dp[i - 1] != -1) {
          dp[i] = dp[i - 1];
        } else {
          dp[i] = i; // start idx
        }
        stack.push(i);
      } else {
        if (!stack.isEmpty()) {
          dp[i] = dp[stack.peek()];
          max = Math.max(max, i - dp[i] + 1);
          stack.pop();
        }
      }
    }
    return max;
  }
}
------------
public class Solution {
  public int longestValidParentheses(String s) {
    Set<Integer> tabu = new HashSet<>();
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(c);
      } else { // ')'
        if (!stack.isEmpty() && stack.peek() == '(') {
          stack.pop();
        } else { // invalid
          tabu.add(i);
          stack.clear();
        }
      }
    }
    stack.clear();
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (c == ')') {
        stack.push(c);
      } else { // '('
        if (!stack.isEmpty() && stack.peek() == ')') {
          stack.pop();
        } else { // invalid
          tabu.add(i);
          stack.clear();
        }
      }
    }

    int ret = 0;
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      if (tabu.contains(i)) {
        ret = Math.max(ret, i - start);
        start = i + 1;
      }
    }
    ret = Math.max(ret, s.length() - start);
    return ret;
  }
}
-------------
public class Solution {
  public int longestValidParentheses(String s) {
    LinkedList<Integer> tabuStack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        tabuStack.offerLast(i);
      } else { // ')'
        if (!tabuStack.isEmpty() && s.charAt(tabuStack.peekLast()) == '(') {
          tabuStack.pollLast();
        } else {
          tabuStack.offerLast(i);
        }
      }
    }
    int ret = 0;
    int last = 0;
    while (!tabuStack.isEmpty()) {
      int idx = tabuStack.pollFirst();
      ret = Math.max(ret, idx - last);
      last = idx + 1;
    }
    ret = Math.max(ret, s.length() - last);
    return ret;
  }
}
