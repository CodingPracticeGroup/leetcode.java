public class Solution {
  public int[] singleNumber(int[] nums) {
    int xor = 0;
    for (int i : nums) {
      xor ^= i;
    }
    int mask = Integer.lowestOneBit(xor);
    int xor_grp1 = 0;
    int xor_grp2 = 0;
    for (int i : nums) {
      if ((mask & i) == 0) {
        xor_grp1 ^= i;
      } else {
        xor_grp2 ^= i;
      }
    }
    return new int[] {xor_grp1, xor_grp2};
  }
}
