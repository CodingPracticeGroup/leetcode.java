public class Solution {
  private boolean isMatch_match(char a, char b) {
    if (b == '?')
      return true;
    if (a == b)
      return true;
    return false;
  }

  public boolean isMatch(String s, String p) {
    boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
    for (int i = 0; i <= s.length(); i++) {
      Arrays.fill(dp[i], false);
    }
    dp[0][0] = true;
    for (int i = 1; i <= p.length(); i++) {
      if (p.charAt(i - 1) == '*') {
        dp[0][i] = true;
      } else {
        break;
      }
    }

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= p.length(); j++) {
        if (p.charAt(j - 1) == '*') {
          boolean f = false;
          if (dp[i][j - 1]) { // 0
            f = true;
          }
          if (dp[i - 1][j]) { // >0
            f = true;
          }
          dp[i][j] = f;
        } else {
          dp[i][j] = dp[i - 1][j - 1] && isMatch_match(s.charAt(i - 1), p.charAt(j - 1));
        }
      }
    }
    return dp[s.length()][p.length()];
  }
}
