import java.util.ArrayDeque;
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
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();

		if (root != null) {
			ArrayDeque<TreeNode> preorder = new ArrayDeque<TreeNode>();// stack
			preorder.push(root);
			while (!preorder.isEmpty()) {
				TreeNode node = preorder.pop();
				ret.add(node.val);
				if (node.right != null)
					preorder.push(node.right);
				if (node.left != null)
					preorder.push(node.left);
			}
		}

		return ret;
	}
}