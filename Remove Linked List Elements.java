public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    ListNode myHead = new ListNode(0);
    myHead.next = head;
    ListNode p = myHead;
    while (p.next != null) {
      if (p.next.val == val) {
        p.next = p.next.next;
      } else {
        p = p.next;
      }
    }
    return myHead.next;
  }
}
