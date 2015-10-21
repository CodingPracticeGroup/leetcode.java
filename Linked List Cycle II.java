public class Solution {
  public ListNode detectCycle(ListNode head) {
    ListNode p1 = head;
    ListNode p2 = head;
    while (p1 != null && p2 != null && p2.next != null) {
      p1 = p1.next;
      p2 = p2.next.next;
      if (p1 == p2) {
        p2 = head;
        while (p1 != p2) {
          p1 = p1.next;
          p2 = p2.next;
        }
        return p1;
      }
    }
    return null;
  }
}
