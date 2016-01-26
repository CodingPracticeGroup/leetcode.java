public class Solution {
  private int findKthLargest_(int[] nums, int k) {
    Queue<Integer> minheap = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      minheap.add(nums[i]);
    }
    for (int i = k; i < nums.length; i++) {
      minheap.add(nums[i]);
      minheap.poll();
    }
    return minheap.poll();
  }

  public int findKthLargest(int[] nums, int k) {
    if (nums.length > 5)
      return findKthLargest_(nums, k);
    Queue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    for (int i : nums) {
      maxheap.add(i);
    }
    for (int i = 1; i < k; i++) {
      maxheap.poll();
    }
    return maxheap.poll();
  }
}
----------
public class Solution {
  public int findKthLargest(int[] nums, int k) {
    Queue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      minHeap.offer(nums[i]);
    }
    for (int i = k; i < nums.length; i++) {
      minHeap.offer(nums[i]);
      minHeap.poll();
    }
    return minHeap.poll();
  }
}
