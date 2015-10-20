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
