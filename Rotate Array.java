public class Solution {
  private void rotate_reverse(int[] nums, int start, int end) {
    while (start < end) {
      int tmp = nums[start];
      nums[start] = nums[end - 1];
      nums[end - 1] = tmp;
      start++;
      end--;
    }
  }

  public void rotate(int[] nums, int k) {
    rotate_reverse(nums, 0, nums.length);
    rotate_reverse(nums, 0, k % nums.length);
    rotate_reverse(nums, k % nums.length, nums.length);
  }
}
