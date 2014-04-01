public class Solution {
	public int removeElement(int[] A, int elem) {
		int insertIdx = 0;
		while (insertIdx < A.length && A[insertIdx] != elem) {
			insertIdx++;
		}

		int pickIdx = insertIdx + 1;
		while (pickIdx < A.length) {
			if (A[pickIdx] == elem) {
				pickIdx++;
			} else {
				A[insertIdx++] = A[pickIdx++];
			}
		}
		return insertIdx;
	}
}