public class Solution {
  public String convertToTitle(int n) {
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
}
