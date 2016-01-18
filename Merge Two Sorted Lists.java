public class Solution {
  public ListNode mergeTwoLists_(ListNode l1, ListNode l2) {
    ListNode ret = new ListNode(0);
    ListNode p = ret;
    while (!(l1 == null && l2 == null)) {
      ListNode q = null;
      if (l1 == null) {
        q = l2;
        l2 = l2.next;
      } else if (l2 == null) {
        q = l1;
        l1 = l1.next;
      } else {
        if (l1.val < l2.val) {
          q = l1;
          l1 = l1.next;
        } else {
          q = l2;
          l2 = l2.next;
        }
      }
      q.next = null;
      //
      p.next = q;
      p = p.next;
    }
    return ret.next;
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode ret = new ListNode(0);
    ListNode p = ret;
    while (l1 != null && l2 != null) {
      ListNode q = null;
      if (l1.val < l2.val) {
        q = l1;
        l1 = l1.next;
      } else {
        q = l2;
        l2 = l2.next;
      }
      p.next = q;
      p = p.next;
    }
    if (l1 != null) {
      p.next = l1;
    } else {
      p.next = l2;
    }
    return ret.next;
  }
}
