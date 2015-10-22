public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int ret = 0;
    for (int i = 0; i < 32; i++) {
      if (((1 << i) & n) != 0)
        ret |= 1 << (31 - i);
    }
    return ret;
  }
}
