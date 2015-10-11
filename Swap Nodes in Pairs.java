public class Solution {
  public ListNode swapPairs(ListNode head) {
    ListNode myHead = new ListNode(0);
    myHead.next = head;
    ListNode p = myHead;
    while (p.next != null && p.next.next != null) {
      ListNode p1 = p.next;
      ListNode p2 = p.next.next;
      ListNode p3 = p.next.next.next;
      p.next = p2;
      p2.next = p1;
      p1.next = p3;
      p = p1;
    }
    return myHead.next;
  }
}
