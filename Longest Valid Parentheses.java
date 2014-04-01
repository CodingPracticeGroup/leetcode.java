public class Solution {
	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return Math.max(left2right(s), right2left(s));
	}

	int left2right(String s) {
		int len = s.length();
		int max = 0;
		int current = 0;
		int tmp_len = 0;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') {
				current++;
			} else if (s.charAt(i) == ')') {
				current--;
			}
			tmp_len++;
			if (current == 0) {
				if (tmp_len > max) {
					max = tmp_len;
				}
			} else if (current < 0) {
				current = 0;
				tmp_len = 0;
			}
		}
		return max;
	}

	int right2left(String s) {
		int len = s.length();
		int max = 0;
		int current = 0;
		int tmp_len = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) == ')') {
				current++;
			} else if (s.charAt(i) == '(') {
				current--;
			}
			tmp_len++;
			if (current == 0) {
				if (tmp_len > max) {
					max = tmp_len;
				}
			} else if (current < 0) {
				current = 0;
				tmp_len = 0;
			}
		}
		return max;
	}
}