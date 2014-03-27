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
	public ListNode partition(ListNode head, int x) {
		ListNode returnPoint = new ListNode(0);
		returnPoint.next = head;

		ListNode insertPoint = returnPoint; // insert after insertPoint
		while (insertPoint.next != null && insertPoint.next.val < x) {
			insertPoint = insertPoint.next;
		}
		if (insertPoint.next != null) {
			ListNode iteratePoint = insertPoint.next;
			while (iteratePoint.next != null) {
				if (iteratePoint.next.val < x) {
					ListNode ln = iteratePoint.next;
					iteratePoint.next = iteratePoint.next.next;

					ln.next = insertPoint.next;
					insertPoint.next = ln;
					insertPoint = ln;
				} else {
					iteratePoint = iteratePoint.next;
				}
			}
		}

		return returnPoint.next;
	}
}