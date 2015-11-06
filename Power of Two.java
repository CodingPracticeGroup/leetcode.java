public class Solution {
  private boolean isPowerOfTwo_test(int n, int offset) {
    return (n & (1 << offset)) != 0;
  }

  public boolean isPowerOfTwo(int n) {
    if (n <= 0)
      return false;
    int count = 0;
    for (int i = 0; i < 32; i++) {
      if (isPowerOfTwo_test(n, i)) {
        count++;
      }
    }
    return count == 1;
  }
}
