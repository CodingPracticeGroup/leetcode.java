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
