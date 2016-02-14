public class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    int s1len = s1.length();
    int s2len = s2.length();

    if (s1len + s2len != s3.length())
      return false;
    if (s3.length() == 0)
      return true;
    if (s1len == 0)
      return s2.equals(s3);
    if (s2len == 0)
      return s1.equals(s3);

    boolean dp[][] = new boolean[s1len + 1][s2len + 1];
    dp[0][0] = true;
    for (int i = 1; i <= s1len; i++) {
      dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) ? dp[i - 1][0] : false;
    }
    for (int i = 1; i <= s2len; i++) {
      dp[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1) ? dp[0][i - 1] : false;
    }
    for (int i = 1; i <= s1len; i++) {
      for (int j = 1; j <= s2len; j++) {
        boolean s1match = s1.charAt(i - 1) == s3.charAt(i + j - 1) ? dp[i - 1][j] : false;
        boolean s2match = s2.charAt(j - 1) == s3.charAt(i + j - 1) ? dp[i][j - 1] : false;
        dp[i][j] = s1match || s2match;
      }
    }
    return dp[s1len][s2len];
  }
}
----------------
public class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() == 0)
      return s2.equals(s3);
    else if (s2.length() == 0)
      return s1.equals(s3);
    if (s1.length() + s2.length() != s3.length())
      return false;

    boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
    for (int i = 0; i <= s1.length(); i++) {
      Arrays.fill(dp[i], false);
    }

    dp[0][0] = true;
    for (int i = 1; i <= s1.length(); i++) {
      dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
    }
    for (int i = 1; i <= s2.length(); i++) {
      dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
    }

    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
          dp[i][j] |= dp[i - 1][j];
        }
        if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
          dp[i][j] |= dp[i][j - 1];
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }
}
