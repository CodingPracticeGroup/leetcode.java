public class Solution {
	public int removeDuplicates(int[] A) {
		if (A.length <= 2) {
			return A.length;
		}

		int insertIdx = 2;
		while (insertIdx < A.length && !(A[insertIdx - 2] == A[insertIdx - 1] && A[insertIdx - 1] == A[insertIdx])) {
			insertIdx++;
		}

		int pickIdx = insertIdx + 1;
		while (pickIdx < A.length) {
			if (A[insertIdx - 2] == A[insertIdx - 1] && A[pickIdx] == A[insertIdx - 1]) {
				pickIdx++;
			} else {
				A[insertIdx++] = A[pickIdx++];
			}
		}

		return insertIdx;
	}
}