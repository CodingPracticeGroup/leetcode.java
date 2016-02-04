public class Solution {
  public void reorderList(ListNode head) {
    ListNode myHead = new ListNode(0);
    myHead.next = head;
    ListNode p1 = myHead;
    ListNode p2 = myHead;
    while (p1 != null && p2 != null && p2.next != null) {
      p1 = p1.next;
      p2 = p2.next.next;
    }

    ListNode myHead2 = new ListNode(0);
    while (p1.next != null) {
      p2 = p1.next;
      p1.next = p2.next;
      p2.next = myHead2.next;
      myHead2.next = p2;
    }

    p1 = myHead.next;
    while (myHead2.next != null) {
      p2 = myHead2.next;
      myHead2.next = p2.next;
      p2.next = p1.next;
      p1.next = p2;
      p1 = p1.next.next;
    }
  }
}
-----------
public class Solution {
  public void reorderList(ListNode head) {
    int len = 0;
    for (ListNode ln = head; ln != null; ln = ln.next) {
      len++;
    }
    if (len == 0) {
      return;
    }
    // find half
    ListNode ln = head;
    int half = len / 2;
    for (int i = 0; i < half; i++) {
      ln = ln.next;
    }
    ListNode second = ln.next;
    ln.next = null;
    // reverse
    ListNode reverse = new ListNode(0);
    while (second != null) {
      ListNode n = second;
      second = second.next;

      n.next = reverse.next;
      reverse.next = n;
    }
    // merge
    for (ListNode l = head; l != null && reverse.next != null; l = l.next.next) {
      ListNode tmp = reverse.next;
      reverse.next = reverse.next.next;

      tmp.next = l.next;
      l.next = tmp;
    }
  }
}
