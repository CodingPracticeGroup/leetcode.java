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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode head = new ListNode(0);
		ListNode p3 = head;
		int tmp = 0;
		while (p1 != null && p2 != null) {
			int sum = p1.val + p2.val + tmp;
			p3.next = new ListNode(sum % 10);
			tmp = sum / 10;
			p1 = p1.next;
			p2 = p2.next;
			p3 = p3.next;
		}
		while (p1 != null) {
			int sum = p1.val + tmp;
			p3.next = new ListNode(sum % 10);
			tmp = sum / 10;
			p1 = p1.next;
			p3 = p3.next;
		}
		while (p2 != null) {
			int sum = p2.val + tmp;
			p3.next = new ListNode(sum % 10);
			tmp = sum / 10;
			p2 = p2.next;
			p3 = p3.next;
		}
		if (tmp != 0) {
			p3.next = new ListNode(tmp);
		}
		return head.next;
	}
}