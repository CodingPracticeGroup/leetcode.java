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
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode preHead = new ListNode(head.val - 1);
		preHead.next = head;

		ListNode start = preHead;
		while (start.next != null) {
			ListNode end = start.next;
			while (end.next != null && end.next.val == start.next.val) {
				end = end.next;
			}
			if (end != start.next) {
				start.next = end.next;
			} else {
				start = start.next;
			}
		}

		return preHead.next;
	}
}