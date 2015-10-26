public class Solution {
  private String shortestPalindrome_check(String s, int i, int j) {
    for (int k = 0; i - k >= 0 && j + k < s.length(); k++) {
      if (s.charAt(i - k) != s.charAt(j + k))
        return null;
    }
    StringBuilder sb = new StringBuilder(s.substring(j + i + 1));
    sb.reverse();
    return sb + s;
  }

  public String shortestPalindrome(String s) {
    int len = s.length();
    if (len == 0)
      return "";
    if (len == 1)
      return s;
    if (len % 2 == 0) {
      for (int i = len / 2; i >= 0; i--) {
        String str = shortestPalindrome_check(s, i - 1, i);
        if (str != null)
          return str;
        str = shortestPalindrome_check(s, i - 1, i - 1);
        if (str != null)
          return str;
      }
    } else {
      for (int i = len / 2; i >= 0; i--) {
        String str = shortestPalindrome_check(s, i, i);
        if (str != null)
          return str;
        str = shortestPalindrome_check(s, i - 1, i);
        if (str != null)
          return str;
      }
    }
    return "";
  }
}
