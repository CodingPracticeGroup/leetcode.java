public class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    int len = 0;
    for (ListNode p = head; p != null; p = p.next) {
      len++;
    }
    ListNode p = head;
    for (int i = 0; i < len / 2 - (len % 2 == 0 ? 1 : 0); i++) {
      p = p.next;
    }
    ListNode myhead = new ListNode(0);
    while (p.next != null) {
      ListNode tmp = p.next;
      p.next = p.next.next;
      tmp.next = myhead.next;
      myhead.next = tmp;
    }

    ListNode orig = head;
    ListNode my = myhead.next;
    while (my != null) {
      if (my.val != orig.val) {
        return false;
      }
      my = my.next;
      orig = orig.next;
    }
    return true;
  }
}
