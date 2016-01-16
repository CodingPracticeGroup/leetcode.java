public class Solution {
  public boolean isPowerOfThree(int n) {
    for (long i = 1; i <= n;) {
      if (i == n) {
        return true;
      }
      i *= 3;
    }
    return false;
  }
}
