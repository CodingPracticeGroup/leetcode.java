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
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = head;
		while (p.next != null) {
			if (p.next.val < p.val) {
				// delete
				ListNode n = p.next;
				p.next = n.next;
				// insert
				if (n.val < head.val) {
					n.next = head;
					head = n;
				} else {
					ListNode t = head;
					while (t.next.val < n.val) {
						t = t.next;
					}
					n.next = t.next;
					t.next = n;
				}
			} else {
				p = p.next;
			}
		}
		return head;
	}
}