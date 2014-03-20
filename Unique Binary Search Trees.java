public class Solution {
	public int numTrees(int n) {
		int dp[] = new int[n + 1]; // dp[i] -> len i
		dp[0] = 1;
		for (int i = 1; i <= n; i++) { // len i
			for (int left = 0; left <= i - 1; left++) { // i -1 = i-root
				dp[i] += dp[left] * dp[i - 1 - left]; // right len = (i- root) -left
			}
		}
		return dp[n];
	}
}