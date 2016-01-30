public class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode myHead = new ListNode(0);
    myHead.next = head;
    ListNode p = myHead;
    for (int i = 0; i < m - 1; i++) {
      p = p.next;
    }
    ListNode tmpHead = new ListNode(0);
    ListNode tmpTail = p.next;
    for (int i = 0; i < n - m + 1; i++) {
      ListNode tmp = p.next;
      p.next = p.next.next;
      tmp.next = tmpHead.next;
      tmpHead.next = tmp;
    }
    tmpTail.next = p.next;
    p.next = tmpHead.next;
    return myHead.next;
  }
}
----------------
public class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode myhead = new ListNode(0);
    myhead.next = head;
    ListNode p = myhead;
    for (int i = 1; i < m; i++) {
      p = p.next;
    }

    ListNode tail = p.next;
    ListNode second = new ListNode(0);
    for (int i = m; i <= n; i++) {
      ListNode q = p.next;
      p.next = q.next;

      q.next = second.next;
      second.next = q;
    }

    tail.next = p.next;
    p.next = second.next;
    return myhead.next;
  }
}
