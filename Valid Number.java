public class Solution {
  public boolean isNumber(String s) {
    s = s.trim();
    int len = s.length();
    int p = 0;
    if (p < len && (s.charAt(p) == '+' || s.charAt(p) == '-')) {
      p++;
    }
    int i = 0;
    while (p + i < len && ('0' <= s.charAt(p + i) && s.charAt(p + i) <= '9')) {
      i++;
    }
    p += i;
    if (p < len && s.charAt(p) == '.') {
      p++;
    }
    int j = 0;
    while (p + j < len && ('0' <= s.charAt(p + j) && s.charAt(p + j) <= '9')) {
      j++;
    }
    p += j;
    if (i + j == 0) {
      return false;
    }
    if (p < len && (s.charAt(p) == 'e' || s.charAt(p) == 'E')) {
      p++;
      if (p < len && (s.charAt(p) == '+' || s.charAt(p) == '-')) {
        p++;
      }
      int k = 0;
      while (p + k < len && ('0' <= s.charAt(p + k) && s.charAt(p + k) <= '9')) {
        k++;
      }
      p += k;
      if (k == 0) {
        return false;
      }
    }
    return p == len;
  }
}
