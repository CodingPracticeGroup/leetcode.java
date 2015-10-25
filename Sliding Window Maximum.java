public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0)
      return new int[0];
    int[] ret = new int[nums.length - k + 1];
    Queue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < k; i++) {
      maxheap.offer(nums[i]);
    }
    ret[0] = maxheap.peek();
    for (int i = 1; i + k - 1 < nums.length; i++) {
      maxheap.remove(nums[i - 1]);
      maxheap.offer(nums[i + k - 1]);
      ret[i] = maxheap.peek();
    }
    return ret;
  }
}
