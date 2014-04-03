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
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode nextK = head;
		for (int i = 0; i < k; i++) {
			if (nextK == null) {
				return head;
			}
			nextK = nextK.next;
		}
		ListNode p = head;
		ListNode reverseP = new ListNode(0);
		reverseP.next = reverseKGroup(nextK, k);
		while (p != nextK) {
			ListNode tmp = p;
			p = p.next;

			tmp.next = reverseP.next;
			reverseP.next = tmp;
		}
		return reverseP.next;
	}
}