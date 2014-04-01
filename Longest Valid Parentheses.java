public class Solution {
	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = s.length();
		if (len == 0)
			return 0;
		int one = onetime(s);
		int two = twotime(s);
		return Math.max(one, two);
	}

	int onetime(String s) {
		int len = s.length();
		int max = 0;
		int cur = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') { // always valid
				sb.append('(');
			} else {
				if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '(') { // valid
					sb.setLength(sb.length() - 1);
					cur += 2;
					if (sb.length() == 0) {
						if (cur > max)
							max = cur;
					}
				} else { // invalid
					if (cur > max)
						max = cur;
					sb.setLength(0);
					cur = 0;
				}
			}
		}
		if (sb.length() == 0 && cur > max)
			max = cur;
		return max;
	}

	int twotime(String s) {
		int len = s.length();
		int max = 0;
		int cur = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) == ')') { // always valid
				sb.append(')');
			} else {
				if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') { // valid
					sb.setLength(sb.length() - 1);
					cur += 2;
					if (sb.length() == 0) {
						if (cur > max)
							max = cur;
					}
				} else { // invalid
					if (cur > max)
						max = cur;
					sb.setLength(0);
					cur = 0;
				}
			}
		}
		if (sb.length() == 0 && cur > max)
			max = cur;
		return max;
	}
}