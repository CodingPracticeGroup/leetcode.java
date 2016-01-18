public class Solution {
  public boolean isPowerOfThree_(int n) {
    if (n <= 0) {
      return false;
    }
    while (n % 3 == 0) {
      n /= 3;
    }
    return n == 1;
  }

  public boolean isPowerOfThree(int n) {
    if (n <= 0) {
      return false;
    }
    return Math.pow(3, Math.round(Math.log(n) / Math.log(3))) == n;
  }
}
