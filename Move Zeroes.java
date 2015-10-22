public class Solution {
  public void moveZeroes(int[] nums) {
    int writer = 0;
    while (writer < nums.length && nums[writer] != 0)
      writer++;
    int reader = writer + 1;
    while (reader < nums.length) {
      while (reader < nums.length && nums[reader] == 0) {
        reader++;
      }
      if (reader < nums.length) {
        nums[writer] = nums[reader];
        nums[reader] = 0;
        writer++;
        reader++;
      }
    }
  }
}
