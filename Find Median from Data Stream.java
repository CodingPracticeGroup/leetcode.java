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
---------------------
public class MedianFinder {
  Integer tmp = null;
  PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // max heap
  PriorityQueue<Integer> large = new PriorityQueue<>(); // default min heap

  // Adds a number into the data structure.
  public void addNum(int num) {
    if (tmp == null) {
      if (small.isEmpty() && large.isEmpty()) {
        tmp = num;
      } else {
        if (num < small.peek()) {
          tmp = small.poll();
          small.offer(num);
        } else if (num > large.peek()) {
          tmp = large.poll();
          large.offer(num);
        } else {
          tmp = num;
        }
      }
    } else {
      if (num < tmp) {
        small.offer(num);
        large.offer(tmp);
      } else {
        small.offer(tmp);
        large.offer(num);
      }
      tmp = null;
    }
  }

  // Returns the median of current data stream
  public double findMedian() {
    if (tmp != null) {
      return tmp;
    } else {
      return (small.peek() + large.peek()) / 2.0;
    }
  }
}
-------------------
class MedianFinder {
  Queue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
  Queue<Integer> minheap = new PriorityQueue<>();
  Integer temp = null;

  // Adds a number into the data structure.
  public void addNum(int num) {
    if (temp != null) {
      if (num < temp) {
        maxheap.offer(num);
        minheap.offer(temp);
      } else {
        maxheap.offer(temp);
        minheap.offer(num);
      }
      temp = null;
      return;
    }
    if (maxheap.isEmpty() && minheap.isEmpty()) {
      temp = num;
      return;
    }
    if (num < maxheap.peek()) {
      temp = maxheap.poll();
      maxheap.offer(num);
    } else if (num > minheap.peek()) {
      temp = minheap.poll();
      minheap.offer(num);
    } else {
      temp = num;
    }
  }

  // Returns the median of current data stream
  public double findMedian() {
    if (temp != null) {
      return temp;
    }
    return (minheap.peek() + maxheap.peek()) / 2.0;
  }
}
