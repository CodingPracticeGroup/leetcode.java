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
	public TreeNode sortedArrayToBST(int[] num) {
		return recusion(num, 0, num.length);
	}

	private TreeNode recusion(int[] num, int idxStart, int idxEnd) {
		if (idxStart >= idxEnd) {
			return null;
		}
		int idxRoot = (idxStart + idxEnd) / 2;
		TreeNode root = new TreeNode(num[idxRoot]);
		root.left = recusion(num, idxStart, idxRoot);
		root.right = recusion(num, idxRoot + 1, idxEnd);
		return root;
	}
}