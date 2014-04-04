public class Solution {
	public String strStr(String haystack, String needle) {
		int idx = haystack.indexOf(needle);
		if (idx < 0) {
			return null;
		} else {
			return haystack.substring(idx, haystack.length());
		}
	}
}