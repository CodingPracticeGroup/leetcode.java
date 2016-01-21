public class Solution {
  public String convertToTitle_(int n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      int t = n % 26;
      n = n / 26;
      if (t == 0) {
        n--;
        sb.append('Z');
      } else {
        sb.append((char) ('A' - 1 + t));
      }
    }
    return sb.reverse().toString();
  }

  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    // (... _*26^3 + _*26^2 + _*26^1 + _*26^0 = n)/26, after removing 26^0, then divide by 26,
    // should still be ==
    while (n > 0) {
      int i = n % 26;
      i = (i + 25) % 26;
      sb.insert(0, (char) ('A' + i));
      n = (n - i - 1) / 26;
    }
    return sb.toString();
  }
}
