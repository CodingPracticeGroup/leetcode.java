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

	// pre-order and in-order are the same. post-order is different
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();

		// stack is not track. stack is used to mark first/second visit
		// ArrayDeque cannot hold null, but LinkedList can
		ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode pointer = root;
		while (!stack.isEmpty() || pointer != null) {
			if (pointer != null) {
				stack.push(pointer);// first time visit node
				pointer = pointer.left; // go left
			} else if (!stack.isEmpty()) {
				TreeNode tn = stack.pop(); // second time visit node
				ret.add(tn.val); // in-order
				pointer = tn.right; // go right
			}
		}

		return ret;
	}

}