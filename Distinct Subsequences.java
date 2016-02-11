public class Solution {
  public int numDistinct(String s, String t) {
    int slen = s.length();
    int tlen = t.length();
    int dp[][] = new int[slen + 1][tlen + 1];
    for (int i = 1; i <= slen; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i <= tlen; i++) {
      dp[0][i] = 0;
    }
    dp[0][0] = 1;
    for (int i = 1; i <= slen; i++) {
      for (int j = 1; j <= tlen; j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[slen][tlen];
  }
}
------------------
public class Solution {
  public int numDistinct(String s, String t) {
    int dp[][] = new int[s.length() + 1][t.length() + 1];
    dp[0][0] = 1; // an empty string contains the empty string 1 time
    for (int i = 1; i <= s.length(); i++) {
      dp[i][0] = 1; // the empty string is a subsequence of any string but only 1 time
    }
    for (int j = 1; j <= t.length(); j++) {
      dp[0][j] = 0; // an empty string cannot contain a non-empty string as a substring
    }
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= t.length(); j++) {
        dp[i][j] = dp[i - 1][j];
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] += dp[i - 1][j - 1];
        }
        // dp[i][j-1]
      }
    }
    return dp[s.length()][t.length()];
  }
}
