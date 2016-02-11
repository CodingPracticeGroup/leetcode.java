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
-----------------
public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    int count = 0;
    for (ListNode p = head; p != null; p = p.next) {
      count++;
      if (count >= k) {
        ListNode r = reverseKGroup(p.next, k);

        ListNode myhead1 = new ListNode(0);
        myhead1.next = head;
        ListNode myhead2 = new ListNode(0);
        while (myhead1.next != p) {
          ListNode t = myhead1.next;
          myhead1.next = t.next;

          t.next = myhead2.next;
          myhead2.next = t;
        }
        p.next = myhead2.next;

        head.next = r;
        return p;
      }
    }
    return head;
  }
}
