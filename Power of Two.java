public class Solution {
  public boolean isPowerOfTwo__(int n) {
    if (n <= 0) {
      return false;
    }
    while (n % 2 == 0) {
      n /= 2;
    }
    return n == 1;
  }

  public boolean isPowerOfTwo_(int n) {
    if (n <= 0) {
      return false;
    }
    return Math.pow(2, Math.round(Math.log(n) / Math.log(2))) == n;
  }

  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }
    return Integer.bitCount(n) == 1;
  }
}
