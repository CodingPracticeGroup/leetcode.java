import java.util.ArrayList;

public class Solution {
	public String countAndSay(int n) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(1);
		for (int i = 2; i <= n; i++) {
			ArrayList<Integer> work = new ArrayList<Integer>();
			int rangeLeft = 0;
			int rangeRight = 1;
			while (rangeRight <= ret.size()) {
				while (rangeRight < ret.size() && ret.get(rangeRight) == ret.get(rangeLeft)) {
					rangeRight++;
				}

				work.add(rangeRight - rangeLeft);
				work.add(ret.get(rangeLeft));

				rangeLeft = rangeRight;
				rangeRight = rangeLeft + 1;
			}
			ret = work;
		}
		StringBuilder sb = new StringBuilder();
		for (Integer i : ret) {
			sb.append(i);
		}
		return sb.toString();
	}
}