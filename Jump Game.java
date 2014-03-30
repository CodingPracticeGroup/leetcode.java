public class Solution {
	// greedy: local optimization leads to global optimization
	// hint in question: max jump at location i -> local optimization
	public boolean canJump(int[] A) {
		int maxLoc = 0; // global optimization
		for (int i = 0; i <= maxLoc && i < A.length; i++) { // iterate every local position i
			maxLoc = Math.max(maxLoc, i + A[i]); // local optimization -> global optimization
		}
		return maxLoc >= A.length - 1;
	}
}