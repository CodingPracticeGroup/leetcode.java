public class NumArray {
  int dp[] = null;

  public NumArray(int[] nums) {
    if (nums.length == 0)
      return;
    dp = new int[nums.length];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = dp[i - 1] + nums[i];
    }
  }

  public int sumRange(int i, int j) {
    if (dp == null)
      return 0;
    return dp[j] - (i - 1 >= 0 ? dp[i - 1] : 0);
  }
}

public class NumArray {
  List<Integer> sum = new ArrayList<>();

  public NumArray(int[] nums) {
    if (nums.length > 0) {
      sum.add(nums[0]);
      for (int i = 1; i < nums.length; i++) {
        sum.add(sum.get(sum.size() - 1) + nums[i]);
      }
    }
  }

  public int sumRange(int i, int j) {
    if (i == 0) {
      return sum.get(j);
    } else {
      return sum.get(j) - sum.get(i - 1);
    }
  }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
