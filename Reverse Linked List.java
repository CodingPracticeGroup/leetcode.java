public class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode myhead = new ListNode(0);
    myhead.next = head;

    ListNode rethead = new ListNode(0);
    while (myhead.next != null) {
      ListNode ln = myhead.next;
      myhead.next = ln.next;
      //
      ln.next = rethead.next;
      rethead.next = ln;
    }
    return rethead.next;
  }

  public ListNode reverseList_(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode tail = head.next;
    ListNode ret = reverseList(head.next);
    tail.next = head;
    head.next = null;
    return ret;
  }
}
