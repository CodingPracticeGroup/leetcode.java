public class Solution {
  public int removeDuplicates(int[] nums) {
    int i = 0; // writer
    int j = 0; // reader
    while (j < nums.length) {
      if (j < nums.length && j + 1 < nums.length && nums[j] == nums[j + 1]) {
        nums[i] = nums[j];
        nums[i + 1] = nums[j + 1];
        i += 2;
        j += 2;
      } else {
        nums[i] = nums[j];
        i += 1;
        j += 1;
      }
      int k = j - 1;
      while (j < nums.length && nums[k] == nums[j]) {
        j++;
      }
    }
    return i;
  }
}
