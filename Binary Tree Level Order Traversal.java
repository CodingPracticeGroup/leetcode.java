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
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

		if (root != null) {
			ArrayList<TreeNode> queueLevel = new ArrayList<TreeNode>();
			// enqueue level
			queueLevel.add(root);
			// while queue is not empty
			while (!queueLevel.isEmpty()) {
				// dequeue level
				ArrayList<TreeNode> tmpQueueLevel = new ArrayList<TreeNode>(queueLevel);
				queueLevel.clear();
				// process
				ArrayList<Integer> tmpQueueLevelInteger = new ArrayList<Integer>();
				for (TreeNode tn : tmpQueueLevel) {
					tmpQueueLevelInteger.add(tn.val);
				}
				ret.add(tmpQueueLevelInteger);
				// enqueue next level
				for (TreeNode tn : tmpQueueLevel) {
					if (tn.left != null) {
						queueLevel.add(tn.left);
					}
					if (tn.right != null) {
						queueLevel.add(tn.right);
					}
				}
			}
		}

		return ret;
	}
}