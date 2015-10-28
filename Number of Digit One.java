public class Solution {
  public int countDigitOne(int n) {
    int ret = 0;
    if (n <= 0)
      return ret;
    for (long i = 1; i <= n; i *= 10) {
      long a = n / (i * 10);
      long b = n % i;
      long c = (n % (i * 10)) / i;
      if (c < 1) {
        ret += a * i;
      } else if (c > 1) {
        ret += (a + 1) * i;
      } else {
        ret += a * i + b + 1;
      }
    }
    return ret;
  }
}
