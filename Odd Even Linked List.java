public class Solution {
  public ListNode oddEvenList(ListNode head) {
    ListNode even = new ListNode(0);
    ListNode p = head;
    ListNode q = even;
    while (p != null && p.next != null) {
      q.next = p.next;
      p.next = p.next.next;

      q = q.next;
      q.next = null;

      if (p.next == null) {
        p.next = even.next;
        break;
      } else if (p.next.next == null) {
        p.next.next = even.next;
        break;
      } else {
        p = p.next;
      }
    }
    return head;
  }
}
