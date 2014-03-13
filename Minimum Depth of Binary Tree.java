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
	public int minDepth(TreeNode root) {
		if (root == null) { // for root only
			return 0;
		}
		// for recursion
		if (root.left != null && root.right != null) {
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		} else if (root.left != null && root.right == null) {
			return minDepth(root.left) + 1;
		} else if (root.left == null && root.right != null) {
			return minDepth(root.right) + 1;
		} else {
			return 1;
		}
	}
}