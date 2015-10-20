import java.util.Arrays;

public class Solution {
  public int minCut(String s) {
    int len = s.length();
    boolean dp[][] = new boolean[len][len]; // [i, j]
    for (int i = 0; i < len; i++) {
      Arrays.fill(dp[i], false);
    }
    for (int i = 0; i < len; i++) {
      for (int j = 0; i - j >= 0 && i + j < len && s.charAt(i - j) == s.charAt(i + j); j++) {
        dp[i - j][i + j] = true;
      }
    }
    for (int i = 1; i < len; i++) {
      for (int j = 0; i - 1 - j >= 0 && i + j < len && s.charAt(i - 1 - j) == s.charAt(i + j); j++) {
        dp[i - 1 - j][i + j] = true;
      }
    }

    int[] dp2 = new int[len + 1]; // fix start=0
    dp2[0] = 0;
    for (int l = 1; l <= len; l++) { // [0,l)
      dp2[l] = dp[0][l - 1] ? 0 : l - 1; // default
      for (int k = 1; k < l; k++) { // 1 hop [k,l)
        if (dp[k][l - 1])
          dp2[l] = Math.min(dp2[k] + 1, dp2[l]);
      }
    }

    return dp2[len];
  }
}
