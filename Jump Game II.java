public class Solution {
	// this solution uses the same greedy idea as Jump Game
	// the modification is that we aggregate each location into location group (step)
	public int jump(int[] A) {
		// enqueue, standing at A[0]
		int rangeLeft = 0, rangeRight = 1;
		// while queue is not empty
		for (int step = 0; rangeLeft < rangeRight; step++) {
			// dequeue

			// process
			if (rangeRight >= A.length) {
				return step;
			}
			// enqueue
			int max = Integer.MIN_VALUE;
			for (int loc = rangeLeft; loc < rangeRight; loc++) {
				max = Math.max(max, loc + A[loc]);
			}
			rangeLeft = rangeRight;
			rangeRight = max + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2 };
		new Solution().jump(A);
	}
}