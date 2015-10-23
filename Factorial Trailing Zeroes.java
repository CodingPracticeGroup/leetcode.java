public class Solution {
  public int trailingZeroes(int n) {
    int ret = 0;
    long pow = 5L;
    while (n >= pow) {
      ret += n / pow;
      pow *= 5;
    }
    return ret;
  }
}
