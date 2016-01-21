public class Solution {
  public String countAndSay(int n) {
    String s = "1";
    if (n == 1) {
      return s;
    }
    for (int i = 2; i <= n; i++) {
      StringBuilder sb = new StringBuilder();
      int anchor = 0;
      while (anchor < s.length()) {
        char c = s.charAt(anchor);
        int count = 1;
        while (anchor + count < s.length() && s.charAt(anchor + count) == c) {
          count++;
        }
        anchor += count;
        sb.append(count);
        sb.append(c);
      }
      s = sb.toString();
    }
    return s;
  }
}
