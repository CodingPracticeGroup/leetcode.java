public class Solution {
  private int insert_bs(List<Interval> intervals, int key) {
    int low = 0;
    int high = intervals.size() - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (key < intervals.get(mid).start) {
        high = mid - 1;
      } else if (intervals.get(mid).start < key) {
        low = mid + 1;
      } else {
        return mid;
      }
    }
    return low;
  }

  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    // newInterval.start <= intervals[insert_pos].start
    int insert_pos = insert_bs(intervals, newInterval.start);
    if (intervals.size() != 0) {
      if (insert_pos < intervals.size() && intervals.get(insert_pos).start == newInterval.start) {
        // 'start' is same, 'start' already combined
      } else {
        if (insert_pos == 0) {
          // no start, independent 'start'
        } else if (insert_pos > 0) {
          if (newInterval.start <= intervals.get(insert_pos - 1).end) {
            // combine 'start' to previous
            insert_pos--;
            newInterval.start = intervals.get(insert_pos).start;
          } else {
            // independent 'start'
          }
        }
      }
      // merge end
      while (insert_pos < intervals.size() && newInterval.end >= intervals.get(insert_pos).start) { // worst case still O(n), should use double binary search
        newInterval.end = Math.max(newInterval.end, intervals.get(insert_pos).end);
        intervals.remove(insert_pos);
      }
    }
    intervals.add(insert_pos, newInterval);
    return intervals;
  }
}
---------------
public class Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    LinkedList<Interval> ret = new LinkedList<>();
    for (Interval i : intervals) {
      if (newInterval != null) {
        if (i.end < newInterval.start) {
          ret.offerLast(i);
        } else if (newInterval.end < i.start) {
          ret.offerLast(newInterval);
          newInterval = null;
          ret.offerLast(i);
        } else {
          newInterval.start = Math.min(newInterval.start, i.start);
          newInterval.end = Math.max(newInterval.end, i.end);
        }
      } else {
        ret.offerLast(i);
      }
    }
    if (newInterval != null) {
      ret.offerLast(newInterval);
    }
    return ret;
  }
}
