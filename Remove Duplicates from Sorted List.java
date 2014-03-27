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
		for (ListNode it = head; it != null; it = it.next) {
			while (it.next != null && it.next.val == it.val) {
				it.next = it.next.next;
			}
		}
		return head;
	}
}