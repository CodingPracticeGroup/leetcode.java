public class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }

    ListNode p1 = head;
    ListNode p2 = head;
    while (p2 != null && p2.next != null && p2.next.next != null) {
      p1 = p1.next;
      p2 = p2.next.next;
    }
    p2 = p1.next;
    p1.next = null;

    p1 = sortList(head);
    p2 = sortList(p2);
    ListNode ret = null;
    ListNode q = null;
    while (p1 != null && p2 != null) {
      ListNode t = null;
      if (p1.val < p2.val) {
        t = p1;
        p1 = p1.next;
      } else {
        t = p2;
        p2 = p2.next;
      }
      if (q == null) {
        q = t;
        ret = t;
      } else {
        q.next = t;
        q = q.next;
      }
    }
    if (p1 != null) {
      q.next = p1;
    }
    if (p2 != null) {
      q.next = p2;
    }
    return ret;
  }
}
