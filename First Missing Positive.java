public class Solution {
	public int firstMissingPositive(int[] A) {
		if (A.length == 0) {
			return 1;
		}

		for (int i = 0; i < A.length; i++) {
			while (0 <= A[i] && A[i] < A.length && A[i] != i && A[i] != A[A[i]]) {
				swap(A, i, A[i]); // for example A[1]=3; swap A[1] and A[3] so that A[3]=3
			}
		}
		for (int i = 1; i < A.length; i++) {
			if (A[i] != i) {
				return i;
			}
		}
		if (A[0] == A.length) {
			return A.length + 1;
		} else {
			return A.length;
		}
	}

	private void swap(int[] A, int idxx, int idxy) {
		int tmp = A[idxx];
		A[idxx] = A[idxy];
		A[idxy] = tmp;
	}
}