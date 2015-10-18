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
