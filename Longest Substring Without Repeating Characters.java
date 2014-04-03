import java.util.HashSet;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int start = 0;
		int end = 1;
		HashSet<Character> set = new HashSet<Character>();
		set.add(s.charAt(start));
		int max = end - start;
		while (end <= s.length()) {
			while (end < s.length() && !set.contains(s.charAt(end))) {
				set.add(s.charAt(end++));
			}
			if (end == s.length()) {
				return Math.max(max, end - start);
			} else {
				max = Math.max(max, end - start);
			}
			while (s.charAt(start) != s.charAt(end)) {
				set.remove(s.charAt(start++));
			}
			start++;
			end++;
		}
		return max;
	}
}