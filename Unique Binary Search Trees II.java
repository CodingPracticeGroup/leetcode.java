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
------------
public class Solution {
  private List<TreeNode> g(int start, int end) { // inclusive
    List<TreeNode> ret = new ArrayList<>();
    if (start > end) {
      ret.add(null);
      return ret;
    } else {
      for (int i = start; i <= end; i++) { // pick root
        List<TreeNode> left = g(start, i - 1);
        List<TreeNode> right = g(i + 1, end);
        for (TreeNode l : left) {
          for (TreeNode r : right) {
            TreeNode root = new TreeNode(i);
            root.left = l;
            root.right = r;
            ret.add(root);
          }
        }
      }
      return ret;
    }
  }

  public List<TreeNode> generateTrees(int n) {
    if (n < 1) {
      return new ArrayList<TreeNode>();
    }
    return g(1, n);
  }
}
