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
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildSubTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
	}

	/*
	 * prerder decides the root that divides inorder into halves
	 */
	private TreeNode buildSubTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
		if (prestart >= preend) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[prestart]);
		for (int i = instart; i < inend; i++) {
			if (inorder[i] == preorder[prestart]) {
				root.left = buildSubTree(preorder, prestart + 1, prestart + 1 + (i - instart), inorder, instart, i);
				root.right = buildSubTree(preorder, prestart + 1 + (i - instart), preend, inorder, i + 1,
						inorder.length);
			}
		}
		return root;
	}
}