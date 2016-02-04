public class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    int len = 0;
    for (ListNode p = head; p != null; p = p.next) {
      len++;
    }
    k = k % len;
    if (k == 0) {
      return head;
    }
    k = len - k;
    ListNode q = head;
    for (int i = 0; i < k - 1; i++) {
      q = q.next;
    }
    ListNode t = q.next;
    q.next = null;
    ListNode s = t;
    while (s.next != null) {
      s = s.next;
    }
    s.next = head;
    return t;
  }
}
--------
public class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    int len = 0;
    for (ListNode ln = head; ln != null; ln = ln.next) {
      len++;
    }
    if (len == 0) {
      return head;
    }
    k %= len;
    if (k == 0) {
      return head;
    }

    ListNode ln = head;
    for (int i = 1; i < len - k; i++) {
      ln = ln.next;
    }

    ListNode tail = ln;
    ln = ln.next;
    tail.next = null;

    ListNode n = ln;
    while (n.next != null) {
      n = n.next;
    }
    n.next = head;

    return ln;
  }
}