public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    ListNode myhead = new ListNode(0);
    myhead.next = head;
    ListNode p = myhead;
    while (p.next != null) {
      if (p.next.val == val) {
        p.next = p.next.next;
      } else {
        p = p.next;
      }
    }
    return myhead.next;
  }
}
