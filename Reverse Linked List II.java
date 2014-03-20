public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m == n)
			return head;
		if (1 == m) {
			ListNode p1 = null;
			ListNode p2 = head;
			for (int i = 1; i <= n; i++) {
				ListNode tmp = p2.next;
				p2.next = p1;
				p1 = p2;
				p2 = tmp;
			}
			head.next = p2;
			return p1;
		}

		ListNode p1 = head;
		ListNode p2 = head.next;
		for (int i = 2; i < m; i++) {
			p1 = p1.next;
			p2 = p2.next;
		}
		ListNode p3 = p2;
		ListNode p4 = p1;
		for (int i = m; i <= n; i++) {
			ListNode tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}
		p3.next = p2;
		p4.next = p1;
		return head;
	}
}