public class Solution {
  String checkBuildReturn(String s, int center1, int center2) {
    for (int i = 0; center1 - i >= 0 && center2 + i < s.length(); i++) {
      if (s.charAt(center1 - i) != s.charAt(center2 + i)) {
        return null;
      }
    }
    StringBuilder sb = new StringBuilder(s.substring(center2 + center1 + 1));
    sb.reverse();
    return sb.toString() + s;
  }

  public String shortestPalindrome(String s) {
    int len = s.length();
    if (len <= 1) {
      return s;
    }
    if (len % 2 == 0) {
      for (int i = len / 2; i - 1 >= 0; i--) {
        String ret = checkBuildReturn(s, i - 1, i);
        if (ret != null) {
          return ret;
        }
        ret = checkBuildReturn(s, i - 1, i - 1);
        if (ret != null) {
          return ret;
        }
      }
    } else {
      for (int i = len / 2; i >= 0; i--) {
        String ret = checkBuildReturn(s, i, i);
        if (ret != null) {
          return ret;
        }
        if (i - 1 >= 0) {
          ret = checkBuildReturn(s, i - 1, i);
          if (ret != null) {
            return ret;
          }
        }
      }
    }
    return null;
  }
}
