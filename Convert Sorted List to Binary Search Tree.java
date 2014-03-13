/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

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
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) { // len 0
			return null;
		}
		if (head.next == null) { // len 1
			return new TreeNode(head.val);
		}
		ListNode slow = head;
		ListNode fast = head.next; // slow->next is root for tree
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.next.val); // root
		root.right = sortedListToBST(slow.next.next); // right
		slow.next = null; // left
		root.left = sortedListToBST(head);
		return root; // return
	}
}