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
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		// assume the leading length before cycle is x
		// assume the cycle length is y
		// when 'slow' enters the cycle, the 'fast' is at (x%y)
		// think that 'fast' is trying to catch 'slow' in the cycle
		// 'fast' gets one step closer to 'slow' when 'fast' moves one advance
		// when they meet, they are at point a:(y-x%y)

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				break;
			}
		}
		if (slow != fast) {
			return null;
		}

		// now, second round, 'fast' and 'slow' move in the same pace
		// when they meet, that point is the answer
		// now we prove it
		// the a point is (x+y-x%y), when it move x, the length will be (x+y-x%y+x%y=x+y=x)

		slow = head;
		while (slow != fast) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}