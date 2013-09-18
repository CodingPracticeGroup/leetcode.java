/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left; TreeNode right;
 * TreeNode(int x) { val = x; } }
 */
public class Solution {
	public int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int max[] = new int[1];
		max[0] = Integer.MIN_VALUE;
		subTree(root, max);
		return max[0];
	}

	int subTree(TreeNode subroot, int[] max) {
		int left_path = 0;
		int right_path = 0;
		if (subroot.left != null)
			left_path = subTree(subroot.left, max);
		if (subroot.right != null)
			right_path = subTree(subroot.right, max);

		int option1 = left_path + subroot.val + right_path;
		int option2 = left_path + subroot.val;
		int option3 = subroot.val + right_path;
		int option4 = subroot.val;

		int cmp234 = Math.max(Math.max(option2, option3), option4);
		int cmp1234 = Math.max(option1, cmp234);
		if (cmp1234 > max[0])
			max[0] = cmp1234;
		return cmp234;
	}
}