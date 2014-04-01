import java.util.Arrays;

public class Solution {
	public boolean search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return searchRange(A, target, 0, A.length);
	}

	boolean searchRange(int[] A, int target, int start, int end) {
		if (end <= start)
			return false;
		if (end - start == 1) {
			if (A[start] == target) {
				return true;
			} else {
				return false;
			}
		}
		if (end - start == 2) {
			if (A[start] == target || A[start + 1] == target) {
				return true;
			} else {
				return false;
			}
		}
		//
		int mid = start + (end - start) / 2;
		if (A[mid] == target)
			return true;
		if (A[start] == A[mid] && A[mid] == A[end - 1]) {
			return searchRange(A, target, start, mid) || searchRange(A, target, mid, end);
		} else if (A[mid] == A[end - 1]) {
			return searchRange(A, target, start, mid);
		} else if (A[start] == A[mid]) {
			return searchRange(A, target, mid, end);
		}
		if (A[start] < A[mid]) { // 2 search here
			if (A[start] <= target && target < A[mid]) { // 2 search
				int bs = Arrays.binarySearch(A, start, mid, target);
				if (bs >= 0)
					return true;
			} else { // repeat
				return searchRange(A, target, mid, end);
			}
		} else if (A[mid] < A[end - 1]) { // 2 search here
			if (A[mid] < target && target <= A[end - 1]) { // 2 search
				int bs = Arrays.binarySearch(A, mid, end, target);
				if (bs >= 0)
					return true;
			} else { // repeat
				return searchRange(A, target, start, mid);
			}
		}
		return false;
	}
}