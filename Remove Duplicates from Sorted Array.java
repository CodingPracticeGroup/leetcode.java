public class Solution {
  private int removeDuplicates_find(int[] nums, int j) {
    int tmp = nums[j];
    while (j < nums.length && nums[j] == tmp) {
      j++;
    }
    return j;
  }

  public int removeDuplicates(int[] nums) {
    int i = 0, j = 0;
    while (j < nums.length) {
      int n = nums[j];
      nums[i] = n;
      i++;
      j = removeDuplicates_find(nums, j);
    }
    return i;
  }
}
