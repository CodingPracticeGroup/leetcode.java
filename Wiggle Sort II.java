public class Solution {
  public void wiggleSort(int[] nums) {
    int dup[] = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      dup[i] = nums[i];
    }
    Arrays.sort(dup);

    int idx = nums.length - 1;
    for (int i = 1; i < nums.length; i += 2) {
      nums[i] = dup[idx--];
    }
    for (int i = 0; i < nums.length; i += 2) {
      nums[i] = dup[idx--];
    }
  }
}
