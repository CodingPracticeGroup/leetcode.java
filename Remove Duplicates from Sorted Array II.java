public class Solution {
  public int removeDuplicates(int[] nums) {
    int writer = 2;
    for (int reader = 2; reader < nums.length; reader++) {
      if (nums[writer - 2] == nums[reader] && nums[writer - 1] == nums[reader]) {
        // do nothing
      } else {
        nums[writer++] = nums[reader];
      }
    }
    return writer;
  }
}
