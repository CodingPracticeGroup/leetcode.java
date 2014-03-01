import java.util.Set;

public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
		int len = s.length();
		boolean[] dpCanDo = new boolean[len]; // substring i-len can be broken
		for (int i = 0; i < len; i++) {
			if (dict.contains(s.substring(i, len))) {
				dpCanDo[i] = true;
			}
		}
		for (int end = len - 1; end > 0; end--) {
			if (dpCanDo[end]) {
				for (int i = 0; i < end; i++) {
					if (dict.contains(s.substring(i, end))) {
						dpCanDo[i] = true;
					}
				}
			}
		}
		return dpCanDo[0];
	}
}