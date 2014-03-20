import java.util.ArrayList;

public class Solution {
	public ArrayList<String> restoreIpAddresses(String s) {

		ArrayList<String> ret = new ArrayList<String>();
		if (s.length() <= 12 && 4 <= s.length()) {
			recursion(s, 3, ret, new String());
		}
		return ret;
	}

	private void recursion(String s, int n, ArrayList<String> ret, String track) {
		if (n == 0 && isValid(s)) {
			String tmp = track + s;
			ret.add(tmp);
			return;
		}
		for (int i = 1; i < s.length() && i <= 3; i++) {
			String sub = s.substring(0, i);
			if (isValid(sub)) {
				String tmp = track + sub + '.';
				recursion(s.substring(i, s.length()), n - 1, ret, tmp);
			}
		}
	}

	private boolean isValid(String s) {
		Integer i = Integer.valueOf(s);
		if (i < 0 || i > 255) {
			return false;
		}
		String ss = String.valueOf(i);
		if (!ss.equals(s)) {
			return false;
		}
		return true;
	}
}