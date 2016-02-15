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
-----------------
public class Solution {
  private void is(String s, int i, int j, boolean dp[][]) { // inclusive
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      dp[i--][j++] = true;
    }
  }

  public int minCut(String s) {
    boolean dp[][] = new boolean[s.length()][s.length()]; // inclusive
    for (int i = 0; i < s.length(); i++) {
      Arrays.fill(dp[i], false);
    }
    for (int i = 0; i < s.length(); i++) {
      is(s, i, i, dp);
      if (i + 1 < s.length()) {
        is(s, i, i + 1, dp);
      }
    }

    int ret = 0;
    Set<Integer> tabu = new HashSet<>(); // visited
    Deque<Integer> q = new ArrayDeque<>(); // stores range head
    tabu.add(0);
    q.offer(0);
    while (!q.isEmpty()) {
      int count = q.size();
      for (int i = 0; i < count; i++) {
        int idx = q.poll(); // poll
        if (idx == s.length()) { // process
          return ret - 1;
        }
        for (int j = idx; j < s.length(); j++) { // offer
          if (dp[idx][j] && !tabu.contains(j + 1)) {
            tabu.add(j + 1);
            q.offer(j + 1);
          }
        }
      }
      ret++;
    }
    return -1;
  }
}
