public class Solution {
  public int trailingZeroes(int n) {
    int ret = 0;
    while (n > 0) {
      n /= 5;
      ret += n;
    }
    return ret;
  }

  public int trailingZeroes_(int n) {
    int ret = 0;
    long pow = 5L;
    while (n >= pow) {
      ret += n / pow;
      pow *= 5;
    }
    return ret;
  }
}
