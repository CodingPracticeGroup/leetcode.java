public class Solution {
	public int searchInsert(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return search(A, target, 0, A.length);
	}

	int search(int[] A, int target, int start, int end) {
		if (end - start == 1) {
			if (target <= A[start])
				return start;
			else
				return end;
		} else if (end - start == 0) {
			return start;
		}
		int mid = (start + end) / 2;
		if (target == A[mid]) {
			return mid;
		} else if (target < A[mid]) {
			return search(A, target, start, mid);
		} else {
			return search(A, target, mid, end);
		}
	}
}