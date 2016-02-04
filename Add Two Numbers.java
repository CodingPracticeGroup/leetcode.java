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
-------------
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode myhead = new ListNode(0);
    int carry = 0;
    ListNode mytail = myhead;
    while (l1 != null || l2 != null || carry != 0) {
      int sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
      carry = sum / 10;
      mytail.next = new ListNode(sum % 10);
      mytail = mytail.next;
      l1 = (l1 == null) ? l1 : l1.next;
      l2 = (l2 == null) ? l2 : l2.next;
    }
    return myhead.next;
  }
}
