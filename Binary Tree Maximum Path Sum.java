/**
 * Definition for binary tree
 */
class TreeNode {
	int val; // may be negative
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {

	int wholeTreeMax = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root != null) {
			contributeMax(root);
		}
		return wholeTreeMax;
	}

	private int contributeMax(TreeNode root) {
		int leftMax = 0, rightMax = 0;
		if (root.left != null) {
			leftMax = Math.max(0, contributeMax(root.left));
		}
		if (root.right != null) {
			rightMax = Math.max(0, contributeMax(root.right));
		}
		wholeTreeMax = Math.max(wholeTreeMax, leftMax + root.val + rightMax);
		return Math.max(root.val + leftMax, root.val + rightMax);
	}

}