class MedianFinder {
  Queue<Integer> high = new PriorityQueue<>(); // min heap
  Queue<Integer> low = new PriorityQueue<>(Collections.reverseOrder()); // max heap
  Integer median = null;

  // Adds a number into the data structure.
  public void addNum(int num) {
    if (median == null) { // even +1
      if (low.isEmpty() && high.isEmpty()) {
        median = num;
      } else {
        if (num < low.peek()) {
          median = low.poll();
          low.offer(num);
        } else if (num > high.peek()) {
          median = high.poll();
          high.offer(num);
        } else {
          median = num;
        }
      }
    } else { // odd +1
      if (num < median) {
        low.offer(num);
        high.offer(median);
      } else {
        low.offer(median);
        high.offer(num);
      }
      median = null;
    }
  }

  // Returns the median of current data stream
  public double findMedian() {
    if (median == null) {
      return (low.peek() + high.peek()) / 2.0;
    } else {
      return median;
    }
  }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
