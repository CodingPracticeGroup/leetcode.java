public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0)
      return new int[0];
    Deque<Integer> window = new ArrayDeque<>();
    for (int i = 0; i < k; i++) {
      window.offerLast(nums[i]);
    }
    int max[] = new int[nums.length - k + 1];
    max[0] = window.stream().mapToInt(x -> x).max().getAsInt();
    for (int i = k; i < nums.length; i++) {
      window.pollFirst();
      window.offerLast(nums[i]);
      max[i - k + 1] = window.stream().mapToInt(x -> x).max().getAsInt();
    }
    return max;
  }
}
