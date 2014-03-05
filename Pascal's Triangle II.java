import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> getRow(int rowIndex) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<Integer> rowLast = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>(rowLast);
			row.add(1);
			for (int j = 1; j < i; j++) {
				row.set(j, rowLast.get(j - 1) + rowLast.get(j));
			}
			rowLast = row;
		}
		return rowLast;
	}
}