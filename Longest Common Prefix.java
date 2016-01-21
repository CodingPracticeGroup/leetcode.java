public class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    int idx = 0;
    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() < strs[idx].length()) {
        idx = i;
      }
    }
    for (int i = 0; i < strs[idx].length(); i++) {
      char c = strs[idx].charAt(i);
      for (String s : strs) {
        if (c != s.charAt(i)) {
          return strs[idx].substring(0, i);
        }
      }
    }
    return strs[idx];
  }
}
