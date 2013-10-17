public class Solution {
	public int singleNumber(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		int ones = 0, twos = 0, xthrees = 0;
		for (int i = 0; i < A.length; ++i) {
			twos |= (ones & A[i]);
			ones ^= A[i];
			xthrees = ~(ones & twos);
			ones &= xthrees;
			twos &= xthrees;
		}
		return ones;
	}
}