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
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;
		return mergeList(sortList(head), sortList(fast));
	}

	private ListNode mergeList(ListNode head1, ListNode head2) {
		ListNode ret = head1.val < head2.val ? head1 : head2;
		if (head1.val < head2.val) {
			ret = head1;
			head1 = head1.next;
		} else {
			ret = head2;
			head2 = head2.next;
		}
		ListNode cur = ret;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				cur.next = head1;
				cur = cur.next;
				head1 = head1.next;
			} else {
				cur.next = head2;
				cur = cur.next;
				head2 = head2.next;
			}
		}
		if (head1 != null) {
			cur.next = head1;
		} else if (head2 != null) {
			cur.next = head2;
		}
		return ret;
	}
}