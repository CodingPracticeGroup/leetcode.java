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
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode half = cutIntoHalves(head);
		half = reverseList(half);
		merge(head, half);
	}

	private ListNode cutIntoHalves(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;
		return fast;
	}

	private ListNode reverseList(ListNode head) {
		ListNode rest = head.next;
		head.next = null;
		ListNode cur = head;
		while (rest != null) {
			// cut
			ListNode t = rest;
			rest = rest.next;
			// insert
			t.next = cur;
			cur = t;
		}
		return cur;
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode ret = head1;
		ListNode cur = null;
		while (head2 != null) {
			ListNode t1 = head1;
			ListNode t2 = head2;
			head1 = head1.next;
			head2 = head2.next;
			//
			t1.next = t2;
			if (cur != null) {
				cur.next = t1;
			}
			cur = t2;
		}
		if (head1 != null) {
			cur.next = head1;
		}
		return ret;
	}

	public static void main(String[] args) {
		ListNode[] test = new ListNode[4];
		test[0] = new ListNode(1);
		test[1] = new ListNode(2);
		test[2] = new ListNode(3);
		test[3] = new ListNode(4);
		test[0].next = test[1];
		test[1].next = test[2];
		test[2].next = null;
		new Solution().reorderList(test[0]);
	}

}