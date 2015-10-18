public class Solution {
  private List<TreeNode> generateTrees_range(int start, int end) {
    List<TreeNode> ret = new ArrayList<>();
    if (end - start == 0) {
      ret.add(null);
      return ret;
    }
    if (end - start == 1) {
      ret.add(new TreeNode(start));
      return ret;
    }
    List<TreeNode> rightOnly = generateTrees_range(start + 1, end);
    for (TreeNode tn : rightOnly) {
      TreeNode root = new TreeNode(start);
      root.right = tn;
      ret.add(root);
    }
    List<TreeNode> leftOnly = generateTrees_range(start, end - 1);
    for (TreeNode tn : leftOnly) {
      TreeNode root = new TreeNode(end - 1);
      root.left = tn;
      ret.add(root);
    }
    for (int root = start + 1; root < end - 1; root++) {
      List<TreeNode> left = generateTrees_range(start, root);
      List<TreeNode> right = generateTrees_range(root + 1, end);
      for (TreeNode tnleft : left) {
        for (TreeNode tnright : right) {
          TreeNode roottn = new TreeNode(root);
          roottn.left = tnleft;
          roottn.right = tnright;
          ret.add(roottn);
        }
      }
    }
    return ret;
  }

  public List<TreeNode> generateTrees(int n) {
    return generateTrees_range(1, n + 1);
  }
}
