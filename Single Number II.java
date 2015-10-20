public class Solution {
  public int singleNumber(int[] nums) {
    int one = 0, two = 0, three = -1;
    for (int i = 0; i < nums.length; i++) {
      int one_ = one;
      int two_ = two;
      int three_ = three;
      one = (one_ | (nums[i] & three_)) & (~(one_ & nums[i]));
      two = (two_ | (nums[i] & one_)) & (~(two_ & nums[i]));
      three = (three_ | (nums[i] & two_)) & (~(three_ & nums[i]));
    }
    return one;
  }
}
