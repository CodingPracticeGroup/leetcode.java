public class Solution {
  private boolean numDecodings_valid(String s, int i, int j) {
    if (i + 2 == j && j <= s.length()) {
      if (s.charAt(i) == '1') {
        return true;
      } else if (s.charAt(i) == '2') {
        if ('0' <= s.charAt(i + 1) && s.charAt(i + 1) <= '6') {
          return true;
        }
      }
    }
    if (i + 1 == j && j <= s.length()) {
      if (s.charAt(i) == '0') {
        return false;
      } else {
        return true;
      }
    }
    return false;
  }

  public int numDecodings(String s) {
    if (s.length() == 0)
      return 0;
    int dp[] = new int[s.length() + 1];
    Arrays.fill(dp, 0);
    dp[0] = 1;
    for (int j = 1; j <= s.length(); j++) {
      if (j - 1 >= 0 && numDecodings_valid(s, j - 1, j)) {
        dp[j] += dp[j - 1];
      }
      if (j - 2 >= 0 && numDecodings_valid(s, j - 2, j)) {
        dp[j] += dp[j - 2];
      }
    }
    return dp[s.length()];
  }
}
