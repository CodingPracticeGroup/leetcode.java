public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0)
      return new int[0];
    int[] ret = new int[nums.length - k + 1];
    Deque<Integer> window = new ArrayDeque<>();
    for (int i = 0; i < k; i++) {
      window.offerLast(nums[i]);
    }
    ret[0] = Collections.max(window);
    for (int i = 1; i + k - 1 < nums.length; i++) {
      window.pollFirst();
      window.offerLast(nums[i + k - 1]);
      ret[i] = Collections.max(window);
    }
    return ret;
  }
}
