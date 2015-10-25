public class Solution {
  private int singleNumber_mask(int x) {
    int count = 0;
    while (((x >>> count) & 1) == 0) {
      count++;
    }
    return 1 << count;
  }

  public int[] singleNumber(int[] nums) {
    int xor = Arrays.stream(nums).reduce((x, y) -> x ^ y).getAsInt();
    int mask = singleNumber_mask(xor);
    int ret[] = new int[2];
    for (int i : nums) {
      if ((i & mask) == 0) {
        ret[0] ^= i;
      } else {
        ret[1] ^= i;
      }
    }
    return ret;
  }
}
