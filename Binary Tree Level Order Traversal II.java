import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

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
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

		if (root != null) {
			ArrayDeque<TreeNode> level = new ArrayDeque<TreeNode>();
			// enqueue root
			level.add(root);
			// while queue is not empty
			while (!level.isEmpty()) {
				// dequeue level
				ArrayDeque<TreeNode> tmp = new ArrayDeque<TreeNode>(level);
				level.clear();
				// process
				ArrayList<Integer> row = new ArrayList<Integer>();
				for (TreeNode tn : tmp) {
					row.add(tn.val);
				}
				ret.add(row);
				// enqueue next level
				for (TreeNode tn : tmp) {
					if (tn.left != null) {
						level.add(tn.left);
					}
					if (tn.right != null) {
						level.add(tn.right);
					}
				}
			}

			Collections.reverse(ret);
		}

		return ret;
	}
}