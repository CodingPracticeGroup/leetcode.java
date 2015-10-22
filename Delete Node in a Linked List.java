public class Solution {
  public void deleteNode(ListNode node) {
    ListNode p = node;
    while (p != null && p.next != null) {
      p.val = p.next.val;
      if (p.next.next == null) {
        p.next = null;
        return;
      }
      p = p.next;
    }
  }
}
