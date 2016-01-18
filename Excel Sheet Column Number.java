public class Solution {
  public int titleToNumber(String s) {
    // ret = .. + x*26^2 + y*26^1 + z*26^0, xyz in [A..Z]
    int ret = 0;
    int base = 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      ret += base * (s.charAt(i) - 'A' + 1);
      base *= 26;
    }
    return ret;
  }
}
