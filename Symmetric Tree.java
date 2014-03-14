import java.util.ArrayDeque;

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
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return recursion(root.left, root.right);
	}

	private boolean recursion(TreeNode leftRoot, TreeNode rightRoot) {
		if (leftRoot == null && rightRoot == null) {
			return true;
		} else if (leftRoot != null && rightRoot != null) {
			return leftRoot.val == rightRoot.val && recursion(leftRoot.left, rightRoot.right)
					&& recursion(leftRoot.right, rightRoot.left);
		}
		return false;
	}

	public boolean isSymmetric2(TreeNode root) {
		if (root != null) {
			ArrayDeque<TreeNode> level = new ArrayDeque<TreeNode>();
			// enqueue
			level.add(root);
			// while level is not empty
			while (!level.isEmpty()) {
				// dequeue
				ArrayDeque<TreeNode> levelTmp = new ArrayDeque<TreeNode>(level);
				// process
				while (level.size() > 1) {
					TreeNode left = level.pollFirst();
					TreeNode right = level.pollLast();
					if (left.val != right.val) {
						return false;
					}
					if ((left.left == null && right.right != null) || (left.left != null && right.right == null)) {
						return false;
					}
					if ((left.right == null && right.left != null) || (left.right != null && right.left == null)) {
						return false;
					}
				}
				if (level.size() == 1) {
					TreeNode node = level.pollFirst();
					if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
						return false;
					}
				}
				level.clear(); // dequeue legacy
				// enqueue next level
				for (TreeNode tn : levelTmp) {
					if (tn.left != null) {
						level.add(tn.left);
					}
					if (tn.right != null) {
						level.add(tn.right);
					}
				}
			}
		}
		return true;
	}
}