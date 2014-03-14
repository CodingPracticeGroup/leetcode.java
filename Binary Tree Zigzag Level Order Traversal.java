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
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

		if (root != null) {
			int height = 0;
			ArrayList<TreeNode> level = new ArrayList<TreeNode>();
			// enqueue level
			level.add(root);
			// while level is not empty
			while (!level.isEmpty()) {
				// dequeue level
				ArrayList<TreeNode> tmp = new ArrayList<TreeNode>(level);
				level.clear();
				// process
				ArrayList<Integer> tmpInt = new ArrayList<Integer>();
				for (TreeNode tn : tmp) {
					tmpInt.add(tn.val);
				}
				if (height % 2 != 0) {
					Collections.reverse(tmpInt);
				}
				height++;
				ret.add(tmpInt);
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
		}

		return ret;
	}
}