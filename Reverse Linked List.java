public class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null)
      return head;
    ListNode ret = reverseList(head.next);
    ListNode p = ret;
    while (p.next != null) {
      p = p.next;
    }
    head.next = p.next;
    p.next = head;
    return ret;
  }
}
