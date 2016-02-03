public class Solution {
  public boolean wordBreak(String s, Set<String> wordDict) {
    boolean dp[] = new boolean[s.length() + 1];
    Arrays.fill(dp, false);
    dp[0] = true;
    for (int len = 1; len <= s.length(); len++) {
      for (int start = 0; start < len; start++) {
        if (dp[start] && wordDict.contains(s.substring(start, len))) {
          dp[len] = true;
        }
      }
    }
    return dp[s.length()];
  }
}
---------
// dfs cannot pass large test, no matter string operation or boolean[][]
// will dfs with prune work?
public class Solution {
  public boolean wordBreak(String s, Set<String> wordDict) {
    boolean dp[] = new boolean[s.length() + 1];
    Arrays.fill(dp, false);
    for (int len = 1; len <= s.length(); len++) {
      if (wordDict.contains(s.substring(0, len))) {
        dp[len] = true;
      } else {
        for (int last = 1; last < len; last++) {
          if (dp[last] == true) {
            if (wordDict.contains(s.substring(last, len))) {
              dp[len] = true;
              break;
            }
          }
        }
      }
    }
    return dp[s.length()];
  }
}
