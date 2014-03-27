public class Solution {
	public void sortColors(int[] A) {
		int overwrite0 = 0; // where to insert 0
		while (overwrite0 < A.length && A[overwrite0] == 0) {
			overwrite0++;
		}
		int overwrite2 = A.length - 1; // where to insert 2
		while (overwrite2 >= 0 && A[overwrite2] == 2) {
			overwrite2--;
		}
		for (int i = overwrite0; i <= overwrite2; i++) {
			if (A[i] == 0) {
				A[i] = A[overwrite0];
				A[overwrite0] = 0;
				overwrite0++;
			} else if (A[i] == 2) {
				A[i] = A[overwrite2];
				A[overwrite2] = 2;
				overwrite2--;
				i--;
			}
		}
	}
}