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
-----------------------
public class Solution {
  public int numDecodings(String s) {
    if (s.length() == 0) {
      return 0;
    }

    int dp[] = new int[s.length()];
    Arrays.fill(dp, 0);

    int i0 = Integer.parseInt(s.substring(0, 1));
    if (i0 > 0) {
      dp[0] = 1;
    }

    if (s.length() >= 2) {
      int i1 = Integer.parseInt(s.substring(1, 2));
      if (i1 > 0) {
        dp[1] += dp[0];
      }
      int i01 = Integer.parseInt(s.substring(0, 2));
      if (i01 >= 10 && i01 <= 26) {
        dp[1] += 1;
      }
    }

    for (int i = 2; i < s.length(); i++) {
      int j = Integer.parseInt(s.substring(i, i + 1));
      if (j > 0) {
        dp[i] += dp[i - 1];
      }
      j = Integer.parseInt(s.substring(i - 1, i + 1));
      if (j >= 10 && j <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[s.length() - 1];
  }
}
