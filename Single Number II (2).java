public class Solution {
	public int singleNumber(int[] A) {
		int zeros = -1, ones = 0, twos = 0;
		for (int i = 0; i < A.length; i++) {
			int tmpZero = zeros;
			int tmpOne = ones;
			int tmpTwo = twos;
			ones = (tmpOne | (tmpZero & A[i])) & (~(tmpOne & A[i]));
			twos = (tmpTwo | (tmpOne & A[i])) & (~(tmpTwo & A[i]));
			zeros = (tmpZero | (tmpTwo & A[i])) & (~(tmpZero & A[i]));
		}
		return ones;
	}

	public static void main(String[] args) throws Exception {
		int A[] = new int[] { -2, -2, -2, 1, 1, 1, -3, -3, -3, -4 };
		new Solution().singleNumber(A);
	}

}
