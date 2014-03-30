import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return ret;
		}
		int maxLevel = Math.min(matrix.length, matrix[0].length) / 2;
		for (int i = 0; i <= maxLevel && ret.size() < matrix.length * matrix[0].length; i++) {
			for (int j = i; j < matrix[0].length - i; j++) {
				ret.add(matrix[i][j]);
			}
			for (int j = i + 1; j < matrix.length - i; j++) {
				ret.add(matrix[j][matrix[0].length - i - 1]);
			}
			if (i < matrix.length - i - 1) {
				for (int j = matrix[0].length - i - 1 - 1; j >= i; j--) {
					ret.add(matrix[matrix.length - i - 1][j]);
				}
			}
			if (i < matrix[0].length - i - 1) {
				for (int j = matrix.length - i - 1 - 1; j > i; j--) {
					ret.add(matrix[j][i]);
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 2, 3 } };
		new Solution().spiralOrder(matrix);
	}
}