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
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) { // only for root
			return false;
		}
		// for recursion
		if (root.val == sum && root.left == null && root.right == null) {
			return true;
		}
		if (root.left != null && hasPathSum(root.left, sum - root.val)) {
			return true;
		}
		if (root.right != null && hasPathSum(root.right, sum - root.val)) {
			return true;
		}
		return false;
	}
}