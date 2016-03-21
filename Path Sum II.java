public class Solution {
  private void pathSum_bt(TreeNode root, int sum, List<List<Integer>> ret, Deque<Integer> stack) {
    if (root.left == null && root.right == null && sum == root.val) {
      stack.offerLast(root.val);
      ret.add(new ArrayList<Integer>(stack));
      stack.pollLast();
    } else {
      stack.offerLast(root.val);
      if (root.left != null) {
        pathSum_bt(root.left, sum - root.val, ret, stack);
      }
      if (root.right != null) {
        pathSum_bt(root.right, sum - root.val, ret, stack);
      }
      stack.pollLast();
    }
  }

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root != null) {
      pathSum_bt(root, sum, ret, new ArrayDeque<Integer>());
    }
    return ret;
  }
}
---------
public class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }
    if (root.left == null && root.right == null && sum == root.val) {
      List<Integer> l = new ArrayList<>();
      l.add(root.val);
      ret.add(l);
      return ret;
    }
    for (List<Integer> l : pathSum(root.left, sum - root.val)) { // process after pop，构造法
      l.add(0, root.val);
      ret.add(l);
    }
    for (List<Integer> l : pathSum(root.right, sum - root.val)) {
      l.add(0, root.val);
      ret.add(l);
    }
    return ret;
  }
}
------------------
public class Solution {
  void ps(TreeNode root, int sum, LinkedList<TreeNode> path, List<List<Integer>> ret) {
    if (root == null)
      return;
    if (root.left == null && root.right == null && root.val == sum) {
      List<Integer> l = new ArrayList<>();
      for (TreeNode tn : path) {
        l.add(tn.val);
      }
      l.add(root.val);
      ret.add(l);
      return;
    }
    path.offerLast(root);
    if (root.left != null)
      ps(root.left, sum - root.val, path, ret);
    if (root.right != null)
      ps(root.right, sum - root.val, path, ret);
    path.pollLast();
  }

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> ret = new ArrayList<>();
    ps(root, sum, new LinkedList<TreeNode>(), ret);
    return ret;
  }
}
