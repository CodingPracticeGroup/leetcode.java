class MedianFinder {

  Queue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
  Queue<Integer> minheap = new PriorityQueue<>();
  Integer mid = null;

  // Adds a number into the data structure.
  public void addNum(int num) {
    if (mid == null) {
      if (!maxheap.isEmpty() && num < maxheap.peek()) {
        mid = maxheap.poll();
        maxheap.offer(num);
      } else if (!minheap.isEmpty() && minheap.peek() < num) {
        mid = minheap.poll();
        minheap.offer(num);
      } else {
        mid = num;
      }
    } else {
      if (mid < num) {
        maxheap.offer(mid);
        minheap.offer(num);
      } else {
        maxheap.offer(num);
        minheap.offer(mid);
      }
      mid = null;
    }
  }

  // Returns the median of current data stream
  public double findMedian() {
    if (mid == null) {
      return (maxheap.peek() + minheap.peek()) / 2.0;
    } else {
      return mid;
    }
  }
}
