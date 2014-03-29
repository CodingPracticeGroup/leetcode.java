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
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || n == 0) {
			return head;
		}

		int len = 0;
		for (ListNode it = head; it != null; it = it.next) {
			len++;
		}
		int nn = n % len;
		if (nn == 0) {
			return head;
		}

		int loc = len - nn;
		ListNode it = head;
		for (int i = 1; i < loc; i++) {
			it = it.next;
		}
		ListNode ret = it.next;
		it.next = null;

		it = ret;
		for (int i = 1; i < nn; i++) {
			it = it.next;
		}
		it.next = head;

		return ret;
	}
}