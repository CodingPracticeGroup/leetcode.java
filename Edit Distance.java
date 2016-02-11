public class Solution {
  public int minDistance(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    int dp[][] = new int[len1 + 1][len2 + 1];
    dp[0][0] = 0;
    for (int i = 1; i <= len1; i++) {
      dp[i][0] = i;
    }
    for (int i = 1; i <= len2; i++) {
      dp[0][i] = i;
    }
    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        dp[i][j] =
            word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1; // replace
        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1); // insert/delete
        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1); // delete/insert
      }
    }
    return dp[len1][len2];
  }
}
------------------
public class Solution {
  public int minDistance(String word1, String word2) {
    int dp[][] = new int[word1.length() + 1][word2.length() + 1];
    dp[0][0] = 0;
    for (int i = 1; i <= word1.length(); i++) {
      dp[i][0] = i;
    }
    for (int j = 1; j <= word2.length(); j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1; // insert/delete
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
        } else {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1); // replace
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }
}
