public class Solution {
	public int numDecodings(String s) {
		if (s.length() == 0) {
			return 0;
		}

		int dp[] = new int[s.length() + 1]; // dp[i] -> i=len
		dp[0] = 1;
		dp[1] = isValid(s.substring(0, 1)) ? 1 : 0;

		for (int i = 2; i <= s.length(); i++) {
			if (isValid(s.substring(i - 1, i))) {
				dp[i] += dp[i - 1];
			}
			if (isValid(s.substring(i - 2, i))) {
				dp[i] += dp[i - 2];
			}
		}

		return dp[s.length()];
	}

	private boolean isValid(String s) {
		if (s.length() > 2) {
			return false;
		}
		Integer i = Integer.valueOf(s);
		if (i <= 0 || i > 26) {
			return false;
		}
		String s2 = String.valueOf(i);
		if (!s.equals(s2)) {
			return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution().numDecodings("110");
	}

}
