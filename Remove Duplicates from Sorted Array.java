public class Solution {
	public int removeDuplicates(int[] A) {
		if (A.length <= 1) {
			return A.length;
		}

		int insertIdx = 1;
		while (insertIdx < A.length && A[insertIdx - 1] != A[insertIdx]) {
			insertIdx++;
		}

		int pickIdx = insertIdx + 1;
		while (pickIdx < A.length) {
			if (A[insertIdx - 1] == A[pickIdx]) {
				pickIdx++;
			} else {
				A[insertIdx++] = A[pickIdx++];
			}
		}

		return insertIdx;
	}
}