/**
 * Definition for binary tree with next pointer.
 */
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class Solution {
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root != null) {
			for (TreeLinkNode memory = root; memory.left != null; memory = memory.left) {
				TreeLinkNode pointer = memory;
				while (pointer != null) {
					pointer.left.next = pointer.right;
					if (pointer.next != null) {
						pointer.right.next = pointer.next.left;
					}
					pointer = pointer.next;
				}
			}
		}
	}
}