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
-----------
public class Solution {
  private TreeNode b(int[] pre, int p_s, int p_e, int[] in, int i_s, int i_e) {
    if (p_s >= p_e || i_s >= i_e) {
      return null;
    }
    int root = pre[p_s];
    TreeNode ret = new TreeNode(root);
    for (int i = i_s; i < i_e; i++) {
      if (root == in[i]) {
        int left_len = i - i_s;
        ret.left = b(pre, p_s + 1, (p_s + 1) + (i - i_s), in, i_s, i);
        ret.right = b(pre, p_e - (i_e - (i + 1)), p_e, in, i + 1, i_e);
        return ret;
      }
    }
    return ret;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return b(preorder, 0, preorder.length, inorder, 0, inorder.length);
  }
}
