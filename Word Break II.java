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
----------------
public class Solution {
  Map<Integer, Set<String>> m = new HashMap<>();

  private Set<String> dfs(String s, Set<String> dict, int startPos) {
    if (m.containsKey(startPos))
      return m.get(startPos);
    Set<String> ret = new HashSet<>();
    if (startPos == s.length()) {
      ret.add("");
      m.put(startPos, ret);
      return ret;
    }
    for (int len = startPos + 1; len <= s.length(); len++) {
      String w = s.substring(startPos, len);
      if (dict.contains(w)) {
        Set<String> r = dfs(s, dict, len);
        for (String ss : r) {
          ret.add(w + " " + ss);
        }
      }
    }
    m.put(startPos, ret);
    return ret;
  }

  public List<String> wordBreak(String s, Set<String> wordDict) {
    Set<String> r = dfs(s, wordDict, 0);
    List<String> ret = new ArrayList<>();
    for (String ss : r) {
      ret.add(ss.trim());
    }
    return ret;
  }
}
