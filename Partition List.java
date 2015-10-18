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
