import java.util.Arrays;

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (target < matrix[0][0])
			return false;
		if (target > matrix[rows - 1][cols - 1])
			return false;

		int top = 0;
		int bottom = rows;
		int row = (top + bottom) / 2;
		while (row != top) { // (0+1)/2=0
			if (target < matrix[row][0]) {
				bottom = row;
			} else {
				top = row;
			}
			row = (top + bottom) / 2;
		}

		int idx = Arrays.binarySearch(matrix[row], target);
		if (idx >= 0) {
			return true;
		} else {
			return false;
		}
	}
}