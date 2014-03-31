public class Solution {
	public int searchInsert(int[] A, int target) {
		int left = 0; // inclusive
		int right = A.length - 1; // inclusive
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target < A[mid]) {
				right = mid - 1;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return left; // insert position
	}
}