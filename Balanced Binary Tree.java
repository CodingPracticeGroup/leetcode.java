/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left; TreeNode right;
 * TreeNode(int x) { val = x; } }
 */
public class Solution {
	public boolean isBalanced(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int height[] = new int[1];
		return subtree(root, height);
	}

	boolean subtree(TreeNode subroot, int height[]) {
		if (subroot == null) {
			height[0] = 1;
			return true;
		}
		boolean b_left = true;
		boolean b_right = true;
		int i_left[] = new int[1];
		i_left[0] = 0;
		int i_right[] = new int[1];
		i_right[0] = 0;
		if (subroot.left != null)
			b_left = subtree(subroot.left, i_left);
		if (subroot.right != null)
			b_right = subtree(subroot.right, i_right);
		if (b_left && b_right && Math.abs(i_left[0] - i_right[0]) <= 1) {
			height[0] = Math.max(i_left[0], i_right[0]) + 1;
			return true;
		} else
			return false;
	}
}