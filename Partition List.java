public class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode leftHead = new ListNode(0);
    ListNode rightHead = new ListNode(0);
    ListNode leftTail = leftHead;
    ListNode rightTail = rightHead;
    while (head != null) {
      if (head.val < x) {
        leftTail.next = head;
        leftTail = leftTail.next;
      } else {
        rightTail.next = head;
        rightTail = rightTail.next;
      }
      head = head.next;
    }
    leftTail.next = rightHead.next;
    rightTail.next = null;
    return leftHead.next;
  }
}
---------
public class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode myhead = new ListNode(0);
    myhead.next = head;
    ListNode tail = myhead;
    ListNode second = new ListNode(0);
    while (tail.next != null) {
      while (tail.next != null && tail.next.val >= x) {
        ListNode tn = tail.next;
        tail.next = tail.next.next;

        tn.next = second.next;
        second.next = tn;
      }
      if (tail.next != null) {
        tail = tail.next;
      }
    }
    while (second.next != null) {
      ListNode tn = second.next;
      second.next = second.next.next;

      tn.next = tail.next;
      tail.next = tn;
    }
    return myhead.next;
  }
}
