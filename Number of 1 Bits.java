public class Solution {
  private boolean hammingWeight_test(int n, int offset) {
    return (n & (1 << offset)) != 0;
  }

  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      if (hammingWeight_test(n, i)) {
        count++;
      }
    }
    return count;
  }
}
