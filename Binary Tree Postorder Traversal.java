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
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();

		if (root != null) {
			ArrayDeque<TreeNode> postOrderStack = new ArrayDeque<TreeNode>();
			postOrderStack.push(root);
			while (!postOrderStack.isEmpty()) {
				TreeNode node = postOrderStack.pop();
				ret.add(node.val);
				if (node.left != null) {
					postOrderStack.push(node.left);
				}
				if (node.right != null) {
					postOrderStack.push(node.right);
				}
			}
			Collections.reverse(ret);
		}

		return ret;
	}
}