/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || head.next == null)
			return head;
		ListNode root = new ListNode(head.val - 1);
		root.next = head;
		ListNode start = head;
		ListNode temp = root;
		ListNode end = head;
		while (end != null) {
			while (end != null && end.val == start.val) {
				end = end.next;
			}
			if (start.next != end) {
				temp.next = end;
			} else {
				temp.next = start;
				temp = start;
			}
			start = end;
		}
		return root.next;
	}
}
