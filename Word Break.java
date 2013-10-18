public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		int len = s.length();
		boolean dp[][] = new boolean[len][len + 1];
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				if (dict.contains(s.substring(i, j))) {
					dp[i][j] = true;
				} else {
					dp[i][j] = false;
				}
			}
		}
		for (int i = 0; i < len; i++) {
			if (dp[0][i] == true) {
				for (int j = i + 1; j <= len; j++) {
					if (dp[i][j] == true) {
						dp[0][j] = true;
					}
				}
			}
		}
		return dp[0][len];
	}
}