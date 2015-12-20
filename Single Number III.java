public class Solution {
  public int[] singleNumber(int[] nums) {
    int xor = 0; // x ^ 0 = x
    for (int n : nums) {
      xor ^= n;
    }
    int mask = Integer.lowestOneBit(xor); //
    int xor_mask0 = 0;
    int xor_mask1 = 0;
    for (int n : nums) {
      if ((n & mask) == 0) {
        xor_mask0 ^= n; // x ^ x = 0
      } else {
        xor_mask1 ^= n; // x ^ x = 0
      }
    }
    return new int[] {xor_mask0, xor_mask1};
  }
}
