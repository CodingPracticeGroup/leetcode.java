public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
		if (A.length == 0) {
			if (B.length % 2 == 0) {
				return (B[B.length / 2 - 1] + B[B.length / 2]) / 2.0;
			} else {
				return B[B.length / 2];
			}
		} else if (B.length == 0) {
			if (A.length % 2 == 0) {
				return (A[A.length / 2 - 1] + A[A.length / 2]) / 2.0;
			} else {
				return A[A.length / 2];
			}
		}
		int count = (A.length + B.length) / 2;
		int idxA = 0;
		int idxB = 0;
		boolean curA = true;
		for (int i = 0; i < count; i++) {
			if (idxA < A.length && idxB < B.length) {
				if (A[idxA] < B[idxB]) {
					idxA++;
					curA = true;
				} else {
					idxB++;
					curA = false;
				}
			} else {
				if (idxA < A.length) {
					idxA++;
					curA = true;
				}
				if (idxB < B.length) {
					idxB++;
					curA = false;
				}
			}
		}
		if ((A.length + B.length) % 2 == 1) {
			if (idxA < A.length && idxB < B.length) {
				if (A[idxA] < B[idxB]) {
					return A[idxA];
				} else {
					return B[idxB];
				}
			} else {
				if (idxA < A.length) {
					return A[idxA];
				}
				if (idxB < B.length) {
					return B[idxB];
				}
			}
		} else {
			int num1 = 0;
			if (curA) {
				num1 = A[idxA - 1];
			} else {
				num1 = B[idxB - 1];
			}
			int num2 = 0;
			if (idxA < A.length && idxB < B.length) {
				if (A[idxA] < B[idxB]) {
					num2 = A[idxA];
				} else {
					num2 = B[idxB];
				}
			} else {
				if (idxA < A.length) {
					num2 = A[idxA];
				}
				if (idxB < B.length) {
					num2 = B[idxB];
				}
			}
			return (num1 + num2) / 2.0;
		}
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = new int[] { 1, 2 };
		int[] B = new int[] { 1, 2, 3 };
		new Solution().findMedianSortedArrays(A, B);
	}

}
