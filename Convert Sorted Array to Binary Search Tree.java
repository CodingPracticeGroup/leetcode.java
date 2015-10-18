public class Solution {
  private TreeNode sortedArrayToBST_range(int[] nums, int start, int end) {
    if (start == end)
      return null;
    int rootidx = (start + end) / 2;
    TreeNode root = new TreeNode(nums[rootidx]);
    root.left = sortedArrayToBST_range(nums, start, rootidx);
    root.right = sortedArrayToBST_range(nums, rootidx + 1, end);
    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST_range(nums, 0, nums.length);
  }
}
