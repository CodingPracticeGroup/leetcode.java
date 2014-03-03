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
	int sum = 0;

	public int sumNumbers(TreeNode root) {
		if (root != null) {
			dfs(root, new StringBuilder());
		}
		return sum;
	}

	private void dfs(TreeNode root, StringBuilder sb) {
		sb.append(root.val);
		if (root.left == null && root.right == null) {
			sum += Integer.valueOf(sb.toString());
		} else {
			if (root.left != null) {
				dfs(root.left, sb);
			}
			if (root.right != null) {
				dfs(root.right, sb);
			}
		}
		sb.deleteCharAt(sb.length() - 1);
	}
}