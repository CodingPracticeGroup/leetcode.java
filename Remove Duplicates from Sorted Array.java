public class Solution {
  public int removeDuplicates(int[] nums) {
    int writer = 1;
    for (int reader = 1; reader < nums.length; reader++) {
      if (nums[reader] != nums[writer - 1]) {
        nums[writer++] = nums[reader];
      }
    }
    return writer;
  }
}
