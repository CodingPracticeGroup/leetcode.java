/**
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		// copy
		RandomListNode p = head;
		while (p != null) {
			RandomListNode q = new RandomListNode(p.label);
			q.next = p.next;
			p.next = q;
			//
			p = q.next;
		}
		// set random
		p = head;
		while (p != null) {
			p.next.random = p.random == null ? null : p.random.next;
			//
			p = p.next.next;
		}
		// mitosis
		RandomListNode r = head.next;
		RandomListNode q = r;
		p = head;
		while (p != null) {
			p.next = q.next;
			p = q.next;

			if (p != null) {
				q.next = p.next;
				q = p.next;
			}
		}
		return r;
	}
}