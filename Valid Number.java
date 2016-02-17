public class Solution {
  public boolean isNumber(String s) {
    s = s.trim();
    int len = s.length();
    int p = 0;
    if (p < len && (s.charAt(p) == '+' || s.charAt(p) == '-')) { // skip
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
    if (i + j == 0) { // check double
	  return false;
    }
    if (p < len && (s.charAt(p) == 'e' || s.charAt(p) == 'E')) {
      p++;
      if (p < len && (s.charAt(p) == '+' || s.charAt(p) == '-')) { // skip
        p++;
      }
      int k = 0;
      while (p + k < len && ('0' <= s.charAt(p + k) && s.charAt(p + k) <= '9')) {
        k++;
      }
      p += k;
      if (k == 0) { // check single
        return false;
      }
    }
    return p == len;
  }
}
---------------
public class Solution {
  private int is(String s, int i) { // one . valid string
    int j = i;
    while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
      j++;
    }
    if (j == s.length())
      return j;
    if (j < s.length() && s.charAt(j) != '.')
      return j;

    int k = j + 1;
    while (k < s.length() && s.charAt(k) >= '0' && s.charAt(k) <= '9') {
      k++;
    }
    return k;
  }

  public boolean isNumber(String s) {
    s = s.trim(); // space
    if (s.equals(""))
      return false;

    int i = 0;
    if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) { // skip +/-
      i++;
    }
    // x.y
    int j = is(s, i);
    if (j == i)
      return false; // empty
    if (j == i + 1 && s.charAt(i) == '.')
      return false; // empty
    if (j == s.length())
      return true;
    i = j;
    // e || E
    if (i < s.length() && (s.charAt(i) != 'e' && s.charAt(i) != 'E')) { // e/E
      return false;
    }
    i++;
    // x.y
    if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) { // skip +/-
      i++;
    }

    j = i;
    while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
      j++;
    }
    if (j == i)
      return false;
    if (j == s.length())
      return true;
    //
    return false;
  }
}
