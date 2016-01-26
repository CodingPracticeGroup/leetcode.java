public class Solution {
  public ListNode swapPairs(ListNode head) {
    ListNode myhead = new ListNode(0);
    myhead.next = head;
    for (ListNode p = myhead; p != null && p.next != null && p.next.next != null; p = p.next.next) {
      ListNode t1 = p.next;
      ListNode t2 = p.next.next;
      p.next = p.next.next.next;

      t1.next = p.next;
      p.next = t1;

      t2.next = p.next;
      p.next = t2;
    }
    return myhead.next;
  }
}
