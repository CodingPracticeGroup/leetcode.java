/**
 * Definition for binary tree with next pointer. public class TreeLinkNode { int val; TreeLinkNode
 * left, right, next; TreeLinkNode(int x) { val = x; } }
 */
public class Solution {
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		TreeLinkNode row_left = root;
		while (row_left != null) {
			TreeLinkNode row_in = row_left;
			while (row_in != null && row_in.left == null && row_in.right == null)
				row_in = row_in.next;
			if (row_in != null) {
				if (row_in.left != null)
					row_left = row_in.left;
				else if (row_in.right != null)
					row_left = row_in.right;
				else {
					row_left = null;
				}
				// found row_left for next layer finally
				while (row_in != null) {
					if (row_in.left != null && row_in.right != null)
						row_in.left.next = row_in.right;
					TreeLinkNode row_in_last = row_in;
					do {
						row_in = row_in.next;
					} while (row_in != null && row_in.left == null && row_in.right == null);
					if (row_in != null)
						if (row_in_last.right != null && row_in.left != null)
							row_in_last.right.next = row_in.left;
						else if (row_in_last.right != null && row_in.right != null)
							row_in_last.right.next = row_in.right;
						else if (row_in_last.left != null && row_in.left != null)
							row_in_last.left.next = row_in.left;
						else if (row_in_last.left != null && row_in.right != null)
							row_in_last.left.next = row_in.right;
				}
			} else {
				row_left = null;
			}
		}
	}
}