public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null)
      return null;
    RandomListNode p = head;
    while (p != null) {
      RandomListNode q = new RandomListNode(p.label);
      q.next = p.next;
      p.next = q;
      p = q.next;
    }
    p = head;
    while (p != null) {
      RandomListNode q = p.random;
      if (q != null) {
        p.next.random = q.next;
      } else {
        p.next.random = null;
      }
      p = p.next.next;
    }
    RandomListNode ret = head.next;
    p = head;
    while (p != null) {
      RandomListNode q = p.next;
      p.next = q.next;
      if (p.next != null) {
        q.next = p.next.next;
      }
      p = p.next;
    }
    return ret;
  }
}
-----------------------
public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    for (RandomListNode p = head; p != null; p = p.next.next) {
      RandomListNode t = new RandomListNode(p.label);
      t.next = p.next;
      p.next = t;
    } // duplicate
    for (RandomListNode p = head; p != null; p = p.next.next) {
      if (p.random != null) {
        p.next.random = p.random.next;
      }
    } // random link
    RandomListNode myhead = new RandomListNode(0);
    RandomListNode mytail = myhead;
    for (RandomListNode p = head; p != null; p = p.next) {
      RandomListNode t = p.next;
      p.next = t.next;

      mytail.next = t;
      mytail = t;
    }
    return myhead.next;
  }
}
