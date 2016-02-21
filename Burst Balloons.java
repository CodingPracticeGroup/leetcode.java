import java.util.Arrays;

public class Solution {
  public int maxCoins(int[] nums) {
    int[] nums_ = new int[nums.length + 2];
    nums_[0] = 1;
    nums_[nums.length + 1] = 1;
    for (int i = 0; i < nums.length; i++) {
      nums_[i + 1] = nums[i];
    }

    int dp[][] = new int[nums.length + 2][nums.length + 2]; // (,)
    for (int[] dp_ : dp) {
      Arrays.fill(dp_, -1);
    }
    for (int i = 0; i + 1 < nums.length + 2; i++) {
      dp[i][i + 1] = 0; // the first balloon
    }

    for (int len = 2; len < nums.length + 2; len++) {
      for (int start = 0; start + len < nums.length + 2; start++) {
        for (int last_divide = start + 1; last_divide < start + len; last_divide++) {
          dp[start][start + len] = Math.max(dp[start][start + len],
              nums_[start] * nums_[last_divide] * nums_[start + len] + dp[start][last_divide]
                  + dp[last_divide][start + len]);
        }
      }
    }

    return dp[0][nums.length + 1];
  }
}
--------------------
public class Solution {
  private int mc(int[] nums, int low, int high, int[][] mem) {
    if (low > high) {
      return 0;
    }
    if (mem[low][high] >= 0) {
      return mem[low][high];
    }
    int ret = 0;
    for (int i = low; i <= high; i++) { // the last balloon
      int left = low - 1 < 0 ? 1 : nums[low - 1];
      int right = high + 1 >= nums.length ? 1 : nums[high + 1];
      ret = Math.max(ret,
          nums[i] * left * right + mc(nums, low, i - 1, mem) + mc(nums, i + 1, high, mem));
    }
    mem[low][high] = ret;
    return ret;
  }

  public int maxCoins(int[] nums) {
    int mem[][] = new int[nums.length][nums.length];
    for (int i = 0; i < nums.length; i++) {
      Arrays.fill(mem[i], -1);
    }
    return mc(nums, 0, nums.length - 1, mem);
  }
}
----------------
public class Solution {
  private int mc(int[] nums, int l_idx, int r_idx, int[][] mem) {
    if (l_idx >= 0 && r_idx >= 0 && l_idx < nums.length && r_idx < nums.length
        && mem[l_idx][r_idx] > 0)
      return mem[l_idx][r_idx];
    int max = 0;
    for (int i = l_idx; i <= r_idx; i++) {
      max =
          Math.max(max,
              mc(nums, l_idx, i - 1, mem)
                  + (l_idx - 1 >= 0 ? nums[l_idx - 1] : 1) * nums[i]
                      * (r_idx + 1 < nums.length ? nums[r_idx + 1] : 1)
              + mc(nums, i + 1, r_idx, mem));
    }
    if (l_idx >= 0 && r_idx >= 0 && l_idx < nums.length && r_idx < nums.length)
      mem[l_idx][r_idx] = max;
    return max;
  }

  public int maxCoins(int[] nums) {
    int mem[][] = new int[nums.length][nums.length]; // since last, no boundary
    return mc(nums, 0, nums.length - 1, mem);
  }
}
