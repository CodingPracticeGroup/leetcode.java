public class Solution {
  private ListNode reverseKGroup_(ListNode head, int k) {
    ListNode p = head.next;
    for (int i = 0; i < k; i++) {
      if (p != null) {
        p = p.next;
      } else {
        return null;
      }
    }

    ListNode myHead = new ListNode(0);
    ListNode myTail = head.next;
    for (int i = 0; i < k; i++) {
      p = head.next;
      head.next = head.next.next;
      p.next = myHead.next;
      myHead.next = p;
    }
    myTail.next = head.next;
    head.next = myHead.next;

    return myTail;
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    int len = 0;
    for (ListNode count = head; count != null; count = count.next) {
      len++;
    }
    if (len == 0 || k > len) {
      return head;
    }

    ListNode myHead = new ListNode(0);
    myHead.next = head;

    for (ListNode p = reverseKGroup_(myHead, k); p != null; p = reverseKGroup_(p, k)) {
    }

    return myHead.next;
  }
}
