public class Solution {
  public int singleNumber(int[] nums) {
    int one = 0;
    int two = 0;
    int three = -1; // last round, all 1, so that can accumulate new int
    for (int i = 0; i < nums.length; i++) {
      int tmp1 = one;
      int tmp2 = two;
      int tmp3 = three;

      one = (tmp1 | (tmp3 & nums[i])) & (~(tmp1 & nums[i])); // one -> tmp1 & nums[i] -> two
      two = (tmp2 | (tmp1 & nums[i])) & (~(tmp2 & nums[i]));
      three = (tmp3 | (tmp2 & nums[i])) & (~(tmp3 & nums[i]));
    }
    return one;
  }
}
