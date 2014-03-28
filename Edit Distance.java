public class Solution {
	// the question mentions one character of the string, which is the hint of dp, becasue dp formulation is always one step.
	// bfs cannot pass
	public int minDistance(String word1, String word2) {
		int dp[][] = new int[word1.length() + 1][word2.length() + 1]; // dp[len of word1][len of word2]
		dp[0][0] = 0;
		for (int i = 1; i <= word1.length(); i++) {
			dp[i][0] = i; // insert/delete
		}
		for (int j = 1; j <= word2.length(); j++) {
			dp[0][j] = j; // insert/delete
		}

		// https://en.wikipedia.org/wiki/Levenshtein_distance#Proof_of_correctness
		// actually, dp[i][j] may come from dp[i+1][j] and dp[i][j+1], which needs proof to be invalid
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				int dpInsert = dp[i - 1][j] + 1;
				int dpDelete = dp[i][j - 1] + 1;
				int dpReplace = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
				dp[i][j] = Math.min(dpReplace, Math.min(dpInsert, dpDelete));
			}
		}

		return dp[word1.length()][word2.length()];
	}

	public static void main(String[] args) {
		new Solution().minDistance("a", "ab");
	}
}