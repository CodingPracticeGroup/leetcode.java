public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			for (int j = prefix.length(); j >= 0; j--) {
				String sub = prefix.substring(0, j);
				if (strs[i].startsWith(sub)) {
					prefix = sub;
					break;
				}
			}
		}
		return prefix;
	}
}