public class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode myhead = new ListNode(0);
    myhead.next = head;
    ListNode ret = new ListNode(0);
    while (myhead.next != null) {
      ListNode t = myhead.next;
      myhead.next = t.next;
      t.next = ret.next;
      ret.next = t;
    }
    return ret.next;
  }
}
