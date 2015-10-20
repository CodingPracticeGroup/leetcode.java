public class Solution {
  private boolean[] wordBreak_dp(String s, Set<String> wordDict) {
    boolean dp[] = new boolean[s.length() + 1];
    Arrays.fill(dp, false);
    dp[s.length()] = true;
    for (int i = s.length() - 1; i >= 0; i--) { // [i, len)
      for (int j = i + 1; j <= s.length(); j++) { // [i, j)
        if (wordDict.contains(s.substring(i, j)) && dp[j]) {
          dp[i] = true;
        }
      }
    }
    return dp;
  }

  private List<String> wordBreak_dfs(String s, Set<String> wordDict, boolean[] dp, int start) {
    List<String> ret = new ArrayList<>();
    String str = s.substring(start);
    if (wordDict.contains(str)) { // [start, len)
      ret.add(str);
    }
    for (int i = start + 1; i <= s.length(); i++) { // [start, i)
      str = s.substring(start, i);
      if (dp[i] && wordDict.contains(str)) {
        List<String> recursion = wordBreak_dfs(s, wordDict, dp, i); // [i, len)
        for (String ss : recursion) {
          ret.add(str + " " + ss);
        }
      }
    }
    return ret;
  }

  public List<String> wordBreak(String s, Set<String> wordDict) {
    boolean dp[] = wordBreak_dp(s, wordDict);
    if (dp[0])
      return wordBreak_dfs(s, wordDict, dp, 0);
    else
      return new ArrayList<>();
  }
}
