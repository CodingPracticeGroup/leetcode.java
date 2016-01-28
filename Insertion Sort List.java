public class Solution {
  public ListNode insertionSortList(ListNode head) {
    if (head == null)
      return null;
    ListNode myHead = new ListNode(Integer.MIN_VALUE);
    myHead.next = head;

    ListNode picknext = myHead;
    while (picknext != null && picknext.next != null) {
      ListNode insertnext = myHead;
      while (insertnext != picknext) {
        if (insertnext.val <= picknext.next.val && picknext.next.val <= insertnext.next.val) {
          break;
        } else {
          insertnext = insertnext.next;
        }
      }
      if (insertnext != picknext) {
        ListNode p = picknext.next;
        picknext.next = p.next;
        p.next = insertnext.next;
        insertnext.next = p;
      } else {
        picknext = picknext.next;
      }
    }
    return myHead.next;
  }
}
-----------
public class Solution {
  public ListNode insertionSortList(ListNode head) {
    ListNode myhead = new ListNode(Integer.MIN_VALUE);
    myhead.next = head;
    for (ListNode p = head; p != null && p.next != null; p = p.next) {
      while (p.next != null && p.val > p.next.val) {
        ListNode tn = p.next;
        p.next = p.next.next;

        ListNode q = myhead;
        while (q.next != p && q.next.val < tn.val) {
          q = q.next;
        }
        tn.next = q.next;
        q.next = tn;
      }
    }
    return myhead.next;
  }
}
