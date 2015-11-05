public class Solution {
  private boolean reverseBits_test(int n, int offset) {
    return (n & (1 << offset)) != 0;
  }

  private int reverseBits_set(int n, int offset) {
    return n | (1 << offset);
  }

  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int ret = 0;
    for (int i = 0; i < 32; i++) {
      if (reverseBits_test(n, i)) {
        ret = reverseBits_set(ret, 31 - i);
      }
    }
    return ret;
  }
}
