import java.util.ArrayList;

/**
 * Definition for an interval.
 */
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Interval> ret = new ArrayList<Interval>();
		boolean insertOnce = true;
		for (Interval i : intervals) {
			if (i.end < newInterval.start) {
				ret.add(i);
			} else if (newInterval.end < i.start) {
				if (insertOnce) {
					ret.add(newInterval);
					insertOnce = false;
				}
				ret.add(i);
			} else {
				newInterval.start = Math.min(i.start, newInterval.start);
				newInterval.end = Math.max(i.end, newInterval.end);
			}
		}
		if (insertOnce) {
			ret.add(newInterval);
		}
		return ret;
	}
}