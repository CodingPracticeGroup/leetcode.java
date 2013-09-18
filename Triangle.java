public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int size = triangle.size();
		int dp[] = new int[size];
		for (int i = 0; i < size; i++)
			dp[i] = 0;
		for (ArrayList<Integer> row : triangle) {
			int size2 = row.size();
			if (size2 - 2 >= 0)
				dp[size2 - 1] = row.get(size2 - 1) + dp[size2 - 2];
			for (int i = size2 - 2; i > 0; i--) {
				dp[i] = Math.min(dp[i - 1], dp[i]) + row.get(i);
			}
			dp[0] += row.get(0);
		}
		int min = dp[0];
		for (int i = 1; i < size; i++)
			if (dp[i] < min)
				min = dp[i];
		return min;
	}
}