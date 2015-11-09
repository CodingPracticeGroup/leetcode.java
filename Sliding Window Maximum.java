public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0)
      return new int[0];
    int ret[] = new int[nums.length - k + 1];
    Deque<Integer> window = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      if (i - k >= 0 && window.peekFirst() == i - k) {
        window.pollFirst();
      }
      while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
        window.pollLast();
      }
      window.offerLast(i);
      if (i - k + 1 >= 0)
        ret[i - k + 1] = nums[window.peekFirst()];
    }
    return ret;
  }
}
