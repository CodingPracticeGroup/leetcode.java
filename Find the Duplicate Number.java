public class Solution {
  private long findDuplicate_count(int[] nums, int k) {
    return Arrays.stream(nums).filter(x -> x > k).count();
  }

  public int findDuplicate(int[] nums) {
    int n = nums.length - 1;
    int low = 1, high = n;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (findDuplicate_count(nums, mid) <= n - mid) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return high;
  }
}
