public class Solution {
	public int singleNumber(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		for (int i = 1; i < A.length; i++)
			A[0] ^= A[i];
		return A[0];
	}
}