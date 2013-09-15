public class Solution {
	public int searchInsert(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null)
			return 0;
		int len = A.length;
		if (len == 0)
			return 0;

		int l = 0;
		int r = len - 1;
		int m = 0;

		while (l <= r) {
			m = (l + r) / 2;
			if (A[m] > target) {
				r = m - 1;
			} else if (A[m] < target) {
				l = m + 1;
			} else {
				return m;
			}
		}

		return r + 1;
	}
}