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
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode new_head = new ListNode(0);
		new_head.next = head;

		ListNode master_start = null, master_end = null, develop_start = null, develop_end = null;
		ListNode iterator = new_head, iterator_pre = null;
		for (int i = 0; i <= n; i++) {
			if (i == m - 1) {
				master_start = iterator;
			}
			if (i == m) {
				develop_end = iterator;
			}
			if (i == n) {
				develop_start = iterator;
			}
			if (m < i && i <= n) {
				ListNode tmp = iterator;
				iterator = iterator.next;
				tmp.next = iterator_pre;
				iterator_pre = tmp;
			} else {
				iterator_pre = iterator;
				iterator = iterator.next;
			}
		}
		master_end = iterator; // n+1

		master_start.next = develop_start;
		develop_end.next = master_end;

		return new_head.next;
	}
}