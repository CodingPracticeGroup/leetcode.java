import java.util.ArrayList;

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
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> track = new ArrayList<Integer>();
		if (root != null)
			recursion(root, sum, track, ret);
		return ret;
	}

	private void recursion(TreeNode root, int sum, ArrayList<Integer> track, ArrayList<ArrayList<Integer>> ret) {
		if (root.val == sum && root.left == null && root.right == null) {
			ArrayList<Integer> col = new ArrayList<Integer>(track);
			col.add(root.val);
			ret.add(col);
			return;
		}
		track.add(root.val);
		if (root.left != null) {
			recursion(root.left, sum - root.val, track, ret);
		}
		if (root.right != null) {
			recursion(root.right, sum - root.val, track, ret);
		}
		track.remove(track.size() - 1);
	}
}