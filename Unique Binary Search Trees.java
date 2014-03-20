public class Solution {
	public int numTrees(int n) {
		return numSubTrees(1, n);
	}

	// it seems that we always need (min, max) in the recursion function for bst
	private int numSubTrees(int min, int max) {
		if (min > max) {
			return 1;
		}
		int sum = 0;
		for (int i = min; i <= max; i++) {
			int left = numSubTrees(min, i - 1);
			int right = numSubTrees(i + 1, max);
			sum += left * right;
		}
		return sum;
	}
}