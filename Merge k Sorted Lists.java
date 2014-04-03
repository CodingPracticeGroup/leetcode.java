import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

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
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		for (ListNode ln : lists) {
			if (ln != null) {
				heap.offer(ln);
			}
		}
		ListNode head = new ListNode(0);
		ListNode p = head;
		while (!heap.isEmpty()) {
			p.next = heap.poll();
			p = p.next;
			if (p.next != null) {
				heap.offer(p.next);
			}
		}
		return head.next;
	}
}