public class Solution {
  private TreeNode buildTree_range(int[] preorder, int prestart, int preend, int[] inorder,
      int instart, int inend) {
    if (prestart == preend)
      return null;
    int rootval = preorder[prestart];
    int inrootidx = instart;
    while (inorder[inrootidx] != rootval) {
      inrootidx++;
    }
    int leftlen = inrootidx - instart;
    TreeNode root = new TreeNode(rootval);
    root.left =
        buildTree_range(preorder, prestart + 1, prestart + 1 + leftlen, inorder, instart, inrootidx);
    root.right =
        buildTree_range(preorder, prestart + 1 + leftlen, preend, inorder, inrootidx + 1, inend);
    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree_range(preorder, 0, preorder.length, inorder, 0, inorder.length);
  }
}
