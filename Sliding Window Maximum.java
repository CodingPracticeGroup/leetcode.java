public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0)
      return new int[0];
    int ret[] = new int[nums.length - k + 1];
    Deque<Integer> window = new ArrayDeque<>(); // max heap
    for (int i = 0; i < nums.length; i++) {
      if (i - k >= 0 && window.peekFirst() == i - k) { // queue
        window.pollFirst();
      }
      while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) { // keep candidate, similar to stack
        window.pollLast();
      }
      window.offerLast(i); // enqueue every item
      if (i - k + 1 >= 0)
        ret[i - k + 1] = nums[window.peekFirst()]; // max heap
    }
    return ret;
  }
}
--------------
public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0)
      return new int[0];
    int[] ret = new int[nums.length - k + 1];
    Queue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < k - 1; i++) {
      maxheap.add(nums[i]);
    }
    for (int i = k - 1; i < nums.length; i++) {
      maxheap.offer(nums[i]);
      ret[i - (k - 1)] = maxheap.peek();
      maxheap.remove(nums[i - (k - 1)]); // no better than the above
    }
    return ret;
  }
}
