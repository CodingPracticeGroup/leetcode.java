/**
 * Definition for binary tree
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public boolean isBalanced(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function

		// cannot use Boolean ret = new Boolean(true); because Boolean does not have setting function
		boolean[] ret = new boolean[1];
		ret[0] = true;
		height(root, ret);
		return ret[0];
	}

	int height(TreeNode root, boolean[] balanced) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left, balanced);
		int rightHeight = height(root.right, balanced);
		if (Math.abs(leftHeight - rightHeight) > 1) {
			balanced[0] = false;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
}