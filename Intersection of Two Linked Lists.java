/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; next = null; } }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode pa = headA;
    ListNode pb = headB;
    while (pa != null && pb != null) {
      pa = pa.next;
      pb = pb.next;
    }
    if (pa == null && pb == null) {
      pa = headA;
      pb = headB;
      while (pa != null && pb != null) {
        if (pa == pb)
          return pa;
        pa = pa.next;
        pb = pb.next;
      }
    } else if (pa == null && pb != null) {
      int count = 0;
      while (pb != null) {
        pb = pb.next;
        count++;
      }
      pa = headA;
      pb = headB;
      for (int i = 0; i < count; i++) {
        pb = pb.next;
      }
      while (pa != null && pb != null) {
        if (pa == pb)
          return pa;
        pa = pa.next;
        pb = pb.next;
      }
    } else if (pa != null && pb == null) {
      int count = 0;
      while (pa != null) {
        pa = pa.next;
        count++;
      }
      pa = headA;
      pb = headB;
      for (int i = 0; i < count; i++) {
        pa = pa.next;
      }
      while (pa != null && pb != null) {
        if (pa == pb)
          return pa;
        pa = pa.next;
        pb = pb.next;
      }
    }
    return null;
  }
}
