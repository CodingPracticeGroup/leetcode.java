public class Solution {
  private int len(ListNode head) {
    int ret = 0;
    while (head != null) {
      ret++;
      head = head.next;
    }
    return ret;
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = len(headA);
    int lenB = len(headB);
    if (lenA < lenB) {
      int delta = lenB - lenA;
      for (int i = 0; i < delta; i++) {
        headB = headB.next;
      }
    } else {
      int delta = lenA - lenB;
      for (int i = 0; i < delta; i++) {
        headA = headA.next;
      }
    }
    while (headA != null && headB != null) {
      if (headA == headB) {
        return headA;
      }
      headA = headA.next;
      headB = headB.next;
    }
    return null;
  }
}
