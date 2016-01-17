public class Solution {
  public void moveZeroes(int[] nums) {
    int idx = 0; // writer
    for (int i = 0; i < nums.length; i++) { // reader
      if (nums[i] != 0) {
        nums[idx++] = nums[i];
      }
    }
    while (idx < nums.length) {
      nums[idx++] = 0;
    }
  }
}
