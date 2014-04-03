/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode swapPairs(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;
		if (head != null && head.next == null)
			return head;
		ListNode p1 = head;
		ListNode p2 = head.next;
		p1.next = swapPairs(p2.next);
		p2.next = p1;
		return p2;
	}
}