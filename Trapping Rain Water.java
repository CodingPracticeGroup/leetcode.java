public class Solution {
	public int trap(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int[] left2right = new int[A.length];
		left2right[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			left2right[i] = Math.max(left2right[i - 1], A[i]);
		}

		int[] right2left = new int[A.length];
		right2left[A.length - 1] = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			right2left[i] = Math.max(right2left[i + 1], A[i]);
		}

		int[] rainElevation = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			rainElevation[i] = Math.min(left2right[i], right2left[i]);
		}

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += rainElevation[i] - A[i];
		}
		return sum;
	}
}