import java.util.ArrayList;

public class Solution {
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int dp[] = new int[10];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = i * dp[i - 1];
		}

		ArrayList<Integer> digits = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++) {
			digits.add(i);
		}

		k--;
		StringBuilder sb = new StringBuilder();
		for (int i = n; i > 1; i--) {
			int idx = k / dp[i - 1];
			sb.append(digits.get(idx));
			digits.remove(idx);
			k = k % dp[i - 1];
		}
		sb.append(digits.get(0));

		return sb.toString();
	}
}