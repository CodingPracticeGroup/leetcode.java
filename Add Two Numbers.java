class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int c = 0;
    ListNode ret = new ListNode(-1);
    ListNode p = ret;
    while (l1 != null && l2 != null) {
      int val = l1.val + l2.val + c;
      p.next = new ListNode(val % 10);
      c = val / 10;
      p = p.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      int val = l1.val + c;
      p.next = new ListNode(val % 10);
      c = val / 10;
      p = p.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      int val = l2.val + c;
      p.next = new ListNode(val % 10);
      c = val / 10;
      p = p.next;
      l2 = l2.next;
    }
    if (c > 0) {
      p.next = new ListNode(c);
    }
    return ret.next;
  }
}
