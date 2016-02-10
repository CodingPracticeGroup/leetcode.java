public class Solution {
  private long findDuplicate_l(int[] nums, int k) {
    return Arrays.stream(nums).filter(x -> x < k).count();
  }

  private long findDuplicate_r(int[] nums, int k) {
    return Arrays.stream(nums).filter(x -> x > k).count();
  }

  public int findDuplicate(int[] nums) {
    int n = nums.length - 1;
    int low = 1;
    int high = n;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      long l = findDuplicate_l(nums, mid);
      long r = findDuplicate_r(nums, mid);
      if (l <= mid - 1 && r <= n - mid) {
        return mid;
      } else if (l > mid - 1) {
        high = mid - 1;
      } else if (r > n - mid) {
        low = mid + 1;
      }
    }
    return -1;
  }
}
--------------
public class Solution {
  public int findDuplicate(int[] nums) {
    int slow = 0;
    int fast = 0; // must not in the cycle
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);
    fast = 0; // move to start point
    do {
      slow = nums[slow];
      fast = nums[fast];
    } while (slow != fast);
    return slow; // they are duplicates
  }
}
