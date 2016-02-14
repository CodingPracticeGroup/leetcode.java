public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    Queue<ListNode> heap = new PriorityQueue<>(lists.length, (x, y) -> x.val - y.val);
    Map<ListNode, Integer> map = new HashMap<>();
    ListNode head = new ListNode(0);
    ListNode p = head;
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        heap.offer(lists[i]);
        map.put(lists[i], i);
        lists[i] = lists[i].next;
      }
    }
    while (!heap.isEmpty()) {
      p.next = heap.poll();
      int idx = map.get(p.next);
      map.remove(p.next);
      p = p.next;
      if (lists[idx] != null) {
        heap.offer(lists[idx]);
        map.put(lists[idx], idx);
        lists[idx] = lists[idx].next;
      }
    }
    return head.next;
  }
}
---------------
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode myhead = new ListNode(0);
    ListNode mytail = myhead;
    PriorityQueue<ListNode> minheap = new PriorityQueue<>((x, y) -> x.val - y.val);
    // minheap.addAll(Arrays.asList(lists));
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) { // cannot add null
        minheap.offer(lists[i]);
      }
    }
    while (!minheap.isEmpty()) {
      ListNode ln = minheap.poll();
      if (ln.next != null) {
        minheap.offer(ln.next);
      }
      mytail.next = ln;
      mytail = ln;
    }
    return myhead.next;
  }
}
