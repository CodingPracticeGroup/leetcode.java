public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    for (TreeLinkNode currentLevelHead = root; currentLevelHead.left != null; currentLevelHead =
        currentLevelHead.left) {
      for (TreeLinkNode p = currentLevelHead; p != null; p = p.next) {
        p.left.next = p.right;
        if (p.next != null) {
          p.right.next = p.next.left;
        }
      }
    }
  }
}
-----------------------
public class Solution {
  public void connect(TreeLinkNode root) {
    for (TreeLinkNode tln = root; tln != null; tln = tln.left) { // level by level
      for (TreeLinkNode tln2 = tln; tln2 != null; tln2 = tln2.next) { // inside level
        if (tln2.left != null) { // prune leaf
          tln2.left.next = tln2.right;
          if (tln2.next != null) { // prune the last inside level
            tln2.right.next = tln2.next.left;
          }
        }
      }
    }
  }
}
