import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		ArrayList<Interval> ret = new ArrayList<Interval>();
		for (Interval i : intervals) {
			if (ret.isEmpty()) {
				ret.add(i);
			} else {
				Interval j = ret.get(ret.size() - 1);
				if (j.end < i.start) {
					ret.add(i);
				} else {
					j.end = Math.max(j.end, i.end);
				}
			}
		}
		return ret;
	}
}