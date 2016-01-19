public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits_(int n) {
    return Integer.reverse(n);
  }

  public int reverseBits__(int n) {
    int ret = 0;
    for (int i = 0; i < 32; i++) {
      int b = (n << i) & Integer.MIN_VALUE;
      ret = (ret >>> 1) | b;
    }
    return ret;
  }

  public int reverseBits(int n) {
    int ret = 0;
    for (int i = 0; i < 32; i++) {
      int b = (n >>> i) & 1;
      ret = (ret << 1) | b;
    }
    return ret;
  }

  private boolean reverseBits_test(int n, int offset) {
    return (n & (1 << offset)) != 0;
  }

  private int reverseBits_set(int n, int offset) {
    return n | (1 << offset);
  }

  // you need treat n as an unsigned value
  public int reverseBits___(int n) {
    int ret = 0;
    for (int i = 0; i < 32; i++) {
      if (reverseBits_test(n, i)) {
        ret = reverseBits_set(ret, 31 - i);
      }
    }
    return ret;
  }
}
