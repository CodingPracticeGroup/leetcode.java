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
