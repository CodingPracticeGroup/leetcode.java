import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return new ArrayList<String>(putDot(s, 3));
	}

	HashSet<String> putDot(String s, int n) {
		HashSet<String> r = new HashSet<String>();
		int len = s.length();
		if (n == 1) {
			for (int i = 1; i <= Math.min(3, len - 1); i++) {
				String part1 = s.substring(0, i);
				String part2 = s.substring(i, len);
				if (part2.length() <= 3 && valid(part1) && valid(part2)) {
					r.add(part1 + '.' + part2);
				}
			}
			return r;
		}

		for (int i = 1; i <= Math.min(3, len - n); i++) {
			String part1 = s.substring(0, i);
			String parts = s.substring(i, len);
			if (valid(part1)) {
				HashSet<String> rr = putDot(parts, n - 1);
				for (Iterator<String> it = rr.iterator(); it.hasNext();) {
					String part2 = it.next();
					r.add(part1 + '.' + part2);
				}
			}
		}
		return r;
	}

	boolean valid(String s) {
		int v = Integer.valueOf(s);
		if (!(0 <= v && v < 256))
			return false;
		if (s.length() > 1 && s.charAt(0) == '0')
			return false;
		return true;
	}
}