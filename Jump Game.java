public class Solution {
	public boolean canJump(int[] A) {
		int maxLoc = 0;
		for (int i = 0; i <= maxLoc && i < A.length; i++) {
			maxLoc = Math.max(maxLoc, i + A[i]);
		}
		return maxLoc >= A.length - 1;
	}
}