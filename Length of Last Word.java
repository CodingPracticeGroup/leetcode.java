public class Solution {
  public int lengthOfLastWord_(String s) {
    s = s.trim();
    int i = s.length() - 1;
    while (i >= 0 && s.charAt(i) != ' ') {
      i--;
    }
    return s.length() - 1 - i;
  }

  public int lengthOfLastWord(String s) {
    int ret = 0;
    int idx = s.length() - 1;
    while (idx >= 0 && s.charAt(idx) == ' ') {
      idx--;
    }
    while (idx >= 0 && s.charAt(idx) != ' ') {
      idx--;
      ret++;
    }
    return ret;
  }
}
