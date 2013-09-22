/**
 * Definition for binary tree with next pointer. public class TreeLinkNode { int val; TreeLinkNode
 * left, right, next; TreeLinkNode(int x) { val = x; } }
 */
public class Solution {
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		TreeLinkNode row_left = root;
		while (row_left != null && row_left.left != null) {
			TreeLinkNode row_in = row_left;
			while (row_in != null) {
				row_in.left.next = row_in.right;
				if (row_in.next != null)
					row_in.right.next = row_in.next.left;
				row_in = row_in.next;
			}
			row_left = row_left.left;
		}
	}
}