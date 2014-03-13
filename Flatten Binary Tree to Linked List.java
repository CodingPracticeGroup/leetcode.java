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
	public void flatten(TreeNode root) {
		if (root != null) {
			preOrderTraversal(root);
		}
	}

	// return last node of pre-order in sub tree
	private TreeNode preOrderTraversal(TreeNode root) {
		if (root.left == null && root.right == null) {
			return root;
		} else if (root.left != null && root.right == null) {
			root.right = root.left;
			root.left = null;
			return preOrderTraversal(root.right);
		} else if (root.left == null && root.right != null) {
			return preOrderTraversal(root.right);
		} else { // if (root.left != null && root.right!=null) {
			TreeNode left = root.left;
			TreeNode right = root.right;

			root.right = root.left;
			root.left = null;

			preOrderTraversal(left).right = right;
			return preOrderTraversal(right);
		}
	}
}