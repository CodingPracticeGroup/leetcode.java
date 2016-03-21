public class Solution {
  private TreeNode build(int[] nums, int start, int end) {
    if (start == end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = build(nums, start, mid);
    root.right = build(nums, mid + 1, end);
    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length);
  }
}
---------------
public class Solution {
  TreeNode satb(int[] nums, int start, int end) {
    if (start == end) {
      return null;
    }
    int root = (start + end) / 2;
    TreeNode ret = new TreeNode(nums[root]);
    ret.left = satb(nums, start, root);
    ret.right = satb(nums, root + 1, end);
    return ret;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return satb(nums, 0, nums.length);
  }
}
