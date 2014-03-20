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
		left = null;
		right = null;
	}
}

public class Solution {
	public ArrayList<TreeNode> generateTrees(int n) {
		return generateSubTrees(1, n); // [1,n]
	}

	// since we want to visit all possibilities, so recursion/dfs is within time limit (no pruning is necessary)
	private ArrayList<TreeNode> generateSubTrees(int min, int max) {
		ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
		if (min > max) {
			ret.add(null); // note this
			return ret;
		}
		for (int i = min; i <= max; i++) {
			ArrayList<TreeNode> leftSubTrees = generateSubTrees(min, i - 1);
			ArrayList<TreeNode> rightSubTrees = generateSubTrees(i + 1, max);
			for (TreeNode left : leftSubTrees) {
				for (TreeNode right : rightSubTrees) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					ret.add(root);
				}
			}
		}
		return ret;
	}
}