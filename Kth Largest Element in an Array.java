public class Solution {
  private int findKthLargest_largeArray(int[] nums, int k) {
    Queue<Integer> heap = new PriorityQueue<>(); // min
    for (int i = 0; i < k; i++)
      heap.offer(nums[i]);
    for (int i = k; i < nums.length; i++) {
      heap.offer(nums[i]);
      heap.poll();
    }
    return heap.poll();
  }

  public int findKthLargest(int[] nums, int k) {
    if (true)
      return findKthLargest_largeArray(nums, k);
    Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); // max
    heap.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    for (int i = 0; i < k - 1; i++)
      heap.poll();
    return heap.poll();
  }
}
