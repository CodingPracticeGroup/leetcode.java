public class Solution {
  public boolean isPalindrome(ListNode head) {
    int count = 0;
    for (ListNode p = head; p != null; p = p.next) {
      count++;
    }
    int half = count / 2;
    ListNode myhead = new ListNode(0);
    myhead.next = head;
    ListNode list2 = new ListNode(0);
    for (int i = 0; i < half; i++) {
      ListNode t = myhead.next;
      myhead.next = t.next;
      t.next = list2.next;
      list2.next = t;
    }
    if (count % 2 != 0) {
      myhead.next = myhead.next.next;
    }
    while (list2.next != null) {
      if (list2.next.val != myhead.next.val) {
        return false;
      }
      list2 = list2.next;
      myhead = myhead.next;
    }
    return true;
  }
}
