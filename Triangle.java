import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> dpLevel = new ArrayList<Integer>(triangle.size());
		dpLevel.add(triangle.get(0).get(0));
		for (int i = 1; i < triangle.size(); i++) {
			ArrayList<Integer> dpLevelDuplicate = new ArrayList<Integer>(dpLevel);
			dpLevel.clear();
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (j == 0) {
					dpLevel.add(dpLevelDuplicate.get(0) + triangle.get(i).get(j));
				} else if (j == triangle.get(i).size() - 1) {
					dpLevel.add(dpLevelDuplicate.get(triangle.get(i - 1).size() - 1) + triangle.get(i).get(j));
				} else {
					dpLevel.add(Math.min(dpLevelDuplicate.get(j - 1), dpLevelDuplicate.get(j)) + triangle.get(i).get(j));
				}
			}
		}
		return Collections.min(dpLevel);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(-1);
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		row2.add(-2);
		row2.add(-3);
		triangle.add(row1);
		triangle.add(row2);
		new Solution().minimumTotal(triangle);
	}

}
