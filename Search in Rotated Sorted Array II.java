import java.util.Arrays;

public class Solution {
	public boolean search(int[] A, int target) {
		return recursion(A, 0, A.length - 1, target);
	}

	private boolean recursion(int[] A, int start, int end, int target) {
		if (start > end) {
			return false;
		}

		int mid = (start + end) / 2;
		if (A[mid] == target) {
			return true;
		}

		if (A[start] == A[mid] && A[mid] == A[end]) { // 3
			return recursion(A, start + 1, mid - 1, target) || recursion(A, mid + 1, end - 1, target);
		} else if (A[start] == A[mid]) { // 2
			return recursion(A, mid + 1, end, target);
		} else if (A[mid] == A[end]) { // 2
			return recursion(A, start, mid - 1, target);
		}

		if (A[start] < A[mid]) {
			if (A[start] <= target && target <= A[mid]) {
				return wrapper(A, start, mid + 1, target);
			} else {
				return recursion(A, mid + 1, end, target);
			}
		} else if (A[mid] < A[end]) {
			if (A[mid] <= target && target <= A[end]) {
				return wrapper(A, mid, end + 1, target);
			} else {
				return recursion(A, start, mid - 1, target);
			}
		}

		return false;
	}

	private boolean wrapper(int[] A, int start, int end, int target) {
		int ret = Arrays.binarySearch(A, start, end, target);
		if (ret >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 1 };
		new Solution().search(A, 0);
	}
}