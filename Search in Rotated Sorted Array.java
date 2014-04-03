import java.util.Arrays;

public class Solution {
	public int search(int[] A, int target) {
		return recursion(A, 0, A.length - 1, target);
	}

	private int recursion(int[] A, int start, int end, int target) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if (A[start] <= A[mid]) {
				if (A[start] <= target && target <= A[mid]) {
					return wrapper(A, start, mid + 1, target);
				} else {
					return recursion(A, mid + 1, end, target);
				}
			} else if (A[mid] <= A[end]) {
				if (A[mid] <= target && target <= A[end]) {
					return wrapper(A, mid, end + 1, target);
				} else {
					return recursion(A, start, mid - 1, target);
				}
			}
		}
		return -1;
	}

	private int wrapper(int[] A, int start, int end, int target) {
		int ret = Arrays.binarySearch(A, start, end, target);
		if (ret >= 0) {
			return ret;
		} else {
			return -1;
		}
	}
}