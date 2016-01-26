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
---------
public class Solution {
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode s1 = head;
    ListNode s2 = head.next;
    while (s1 != s2) {
      if (s1 != null) {
        s1 = s1.next;
      } else {
        return null;
      }
      if (s2 != null && s2.next != null) {
        s2 = s2.next.next;
      } else {
        return null;
      }
    }
    s1 = s1.next;
    s2 = head;
    while (s1 != s2) {
      s1 = s1.next;
      s2 = s2.next;
    }
    return s1;
  }
}
