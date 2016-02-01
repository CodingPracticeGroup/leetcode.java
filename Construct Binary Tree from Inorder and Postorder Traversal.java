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
-----------
public class Solution {
  private TreeNode b(int[] in, int i_s, int i_e, int[] post, int p_s, int p_e) {
    if (i_s >= i_e || p_s >= p_e) {
      return null;
    }
    int root = post[p_e - 1];
    TreeNode ret = new TreeNode(root);
    for (int i = i_s; i < i_e; i++) {
      if (root == in[i]) {
        ret.left = b(in, i_s, i, post, p_s, p_s + (i - i_s));
        ret.right = b(in, i + 1, i_e, post, (p_e - 1) - (i_e - (i + 1)), p_e - 1);
        return ret;
      }
    }
    return ret;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return b(inorder, 0, inorder.length, postorder, 0, postorder.length);
  }
}
