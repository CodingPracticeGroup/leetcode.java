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

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode left = head;
		ListNode right = head;
		for (int i = 0; i < n; i++) {
			right = right.next;
		}
		if (right == null) {
			return head.next;
		}
		while (right.next != null) {
			left = left.next;
			right = right.next;
		}
		left.next = left.next.next;
		return head;
	}
}