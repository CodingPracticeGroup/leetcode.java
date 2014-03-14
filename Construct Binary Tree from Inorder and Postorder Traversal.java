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
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildSubTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	/* postorder decides root that divides inorder into halves */
	private TreeNode buildSubTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
		if (poststart > postend) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postend]);
		for (int i = inend; i >= 0; i--) {
			if (inorder[i] == postorder[postend]) {
				root.right = buildSubTree(inorder, i + 1, inend, postorder, postend - (inend - i), postend - 1);
				root.left = buildSubTree(inorder, instart, i - 1, postorder, poststart, postend - (inend - i) - 1);
			}
		}
		return root;
	}
}