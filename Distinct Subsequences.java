public class Solution {
	public int numDistinct(String S, String T) {
		// prune half of matrix
		if (S.length() < T.length()) {
			return 0;
		}

		// dp matrix, dp[i][j] -> s.len(i) & t.len(j)
		int dpNum[][] = new int[S.length() + 1][T.length() + 1];

		// initialize boundary
		for (int i = 1; i <= S.length(); i++) {
			dpNum[i][0] = 1;
		}

		// initialize boundary
		for (int j = 1; j <= T.length(); j++) {
			if (S.substring(0, j).equals(T.substring(0, j))) {
				dpNum[j][j] = 1;
			} else {
				dpNum[j][j] = 0;
			}
		}

		// fill triangle in matrix
		for (int j = 1; j <= T.length(); j++) {
			for (int i = j + 1; i <= S.length(); i++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					dpNum[i][j] = dpNum[i - 1][j - 1] + dpNum[i - 1][j];
				} else {
					dpNum[i][j] = dpNum[i - 1][j];
				}
			}
		}

		// result
		return dpNum[S.length()][T.length()];
	}
}