public class Solution {
  private TreeNode buildTree_range(int[] inorder, int instart, int inend, int[] postorder,
      int poststart, int postend) {
    if (instart == inend)
      return null;
    int rootval = postorder[postend - 1];
    int inrootidx = instart;
    while (inorder[inrootidx] != rootval) {
      inrootidx++;
    }
    int rightlen = inend - inrootidx - 1;
    int leftlen = inrootidx - instart;
    TreeNode root = new TreeNode(rootval);
    root.left =
        buildTree_range(inorder, instart, inrootidx, postorder, poststart, poststart + leftlen);
    root.right =
        buildTree_range(inorder, inrootidx + 1, inend, postorder, postend - 1 - rightlen,
            postend - 1);
    return root;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree_range(inorder, 0, inorder.length, postorder, 0, postorder.length);
  }
}
