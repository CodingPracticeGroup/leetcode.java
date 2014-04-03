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
	public ListNode swapPairs(ListNode head) {
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode cur = preHead;
		ListNode curNextTwo = null;
		if (cur.next != null) {
			curNextTwo = cur.next.next;
		}
		while (curNextTwo != null) {
			ListNode first = cur.next;
			ListNode second = first.next;

			first.next = second.next;
			second.next = first;
			cur.next = second;

			cur = first;
			if (cur.next != null) {
				curNextTwo = cur.next.next;
			} else {
				curNextTwo = null;
			}
		}
		return preHead.next;
	}
}