import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0) {
			return triangle;
		}

		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(1);
		triangle.add(row);

		for (int i = 1; i < numRows; i++) {
			ArrayList<Integer> rowDuplicate = new ArrayList<Integer>(row);
			for (int j = 1; j < i ; j++) {
				rowDuplicate.set(j, row.get(j - 1) + row.get(j));
			}
			rowDuplicate.add(1);
			triangle.add(rowDuplicate);
			row = rowDuplicate;
		}

		return triangle;
	}

	public static void main(String[] args) {
		new Solution().generate(3);
	}
}