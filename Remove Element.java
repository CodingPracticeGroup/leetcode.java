public class Solution {
  private int removeElement_findNextRead(int[] nums, int val, int read) {
    read++;
    while (read < nums.length) {
      if (nums[read] != val) {
        return read;
      } else {
        read++;
      }
    }
    return read;
  }

  public int removeElement(int[] nums, int val) {
    int start = 0;
    while (start < nums.length && nums[start] == val) {
      start++;
    }
    if (start == nums.length) {
      return 0;
    }
    int read = start, write = 0;
    while (read < nums.length) {
      nums[write] = nums[read];
      write++;
      read = removeElement_findNextRead(nums, val, read);
    }
    return write;
  }
}
