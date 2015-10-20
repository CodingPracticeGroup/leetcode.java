public class Solution {
  private void connect_level(TreeLinkNode root) {
    while (root != null) {
      root.left.next = root.right;
      if (root.next != null) {
        root.right.next = root.next.left;
      }
      root = root.next;
    }
  }

  public void connect(TreeLinkNode root) {
    if (root == null)
      return;
    while (root.left != null) {
      connect_level(root);
      root = root.left;
    }
  }
}
