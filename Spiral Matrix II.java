public class Solution {
	public int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];
		int fill = 1;
		for (int level = 0; level <= n / 2; level++) {
			for (int i = level; i < n - level; i++) {
				ret[level][i] = fill++;
			}
			for (int i = level + 1; i < n - level; i++) {
				ret[i][n - level - 1] = fill++;
			}
			for (int i = n - level - 2; i >= level; i--) {
				ret[n - level - 1][i] = fill++;
			}
			for (int i = n - level - 2; i > level; i--) {
				ret[i][level] = fill++;
			}
		}
		return ret;
	}
}