public class Solution {
  public int singleNumber(int[] nums) {
    return Arrays.stream(nums).reduce((x, y) -> x ^ y).getAsInt();
  }

  public int singleNumber_(int[] nums) {
    int ret = 0;
    for (int i : nums) {
      ret ^= i;
    }
    return ret;
  }
}
