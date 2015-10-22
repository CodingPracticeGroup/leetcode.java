public class Solution {
  public boolean isPowerOfTwo(int n) {
    long power = 1L;
    while (power < n) {
      power = power << 1;
    }
    if (power == n)
      return true;
    else
      return false;
  }
}
