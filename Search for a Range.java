public class Solution {
	public int[] searchRange(int[] A, int target) {
		int[] ret = new int[2];

		int left = 0;
		int right = A.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2; // floor
			if (target < A[mid]) {
				right = mid - 1;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				if (A[left] < target) {
					right = mid;
				} else {
					break;
				}
			}
		}
		if (left > right) {
			ret[0] = -1;
			ret[1] = -1;
			return ret;
		}
		ret[0] = left; // this is where to insert. note the floor and ceil differences

		left = 0;
		right = A.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2 + (left + right) % 2; // ceil
			if (target < A[mid]) {
				right = mid - 1;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				if (target < A[right]) {
					left = mid;
				} else {
					break;
				}
			}
		}
		ret[1] = right;

		return ret;
	}

	public static void main(String[] args) {
		int[] A = { 2, 2 };
		new Solution().searchRange(A, 3);
	}
}