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
