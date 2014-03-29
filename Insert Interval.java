import java.util.ArrayList;
import java.util.Iterator;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Interval> r = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			r.add(newInterval);
			return r;
		}
		for (Iterator<Interval> it = intervals.iterator(); it.hasNext();) {
			Interval tmp = it.next();
			if (newInterval == null)
				r.add(tmp);
			else if (tmp.end < newInterval.start) {
				r.add(tmp);
			} else if (newInterval.end < tmp.start) {
				if (newInterval != null) {
					r.add(newInterval);
					newInterval = null;
				}
				r.add(tmp);
			} else {
				newInterval.start = Math.min(newInterval.start, tmp.start);
				newInterval.end = Math.max(newInterval.end, tmp.end);
			}
		}
		if (newInterval != null)
			r.add(newInterval);
		return r;
	}
}