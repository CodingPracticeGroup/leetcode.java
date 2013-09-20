/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;

		ListNode super_head = new ListNode(head.val - 1);
		super_head.next = head;

		ListNode p1 = super_head;
		ListNode p2 = p1.next;
		while (p2 != null) {
			while (p2 != null && p2.next != null && p2.val == p2.next.val) {
				while (p2.next != null && p2.val == p2.next.val) {
					p2 = p2.next;
				}
				if (p2 != p1.next) {
					p2 = p2.next;
				}
			}
			p1.next = p2;

			p1 = p2;
			if (p1 == null)
				break;
			p2 = p1.next;
		}

		return super_head.next;
	}
}