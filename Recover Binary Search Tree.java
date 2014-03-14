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
	TreeNode wrong1;
	TreeNode wrong2;
	TreeNode prev;

	public void recoverTree(TreeNode root) {
		wrong1 = null;
		wrong2 = null;
		prev = new TreeNode(Integer.MIN_VALUE);
		inorder(root);
		int tmp = wrong1.val;
		wrong1.val = wrong2.val;
		wrong2.val = tmp;
	}

	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		if (prev.val > root.val) {
			markWrong(prev, root);
		}
		prev = root;
		inorder(root.right);
	}

	private void markWrong(TreeNode wrong, TreeNode wrongPost) {
		if (wrong1 == null) {
			wrong1 = wrong;
			wrong2 = wrongPost;
			return;
		} else {
			wrong2 = wrongPost;
			return;
		}
	}
}