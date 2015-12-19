import java.util.Arrays;

public class Solution {
  int burst(int[][] mem, int[] nums_, int start, int end) { // (start, end)
    if (mem[start][end] >= 0) {
      return mem[start][end];
    } else if (start + 1 == end) {
      mem[start][end] = 0;
      return mem[start][end];
    }
    for (int i = start + 1; i < end; i++) { // last
      mem[start][end] = Math.max(mem[start][end], nums_[start] * nums_[i] * nums_[end]
          + burst(mem, nums_, start, i) + burst(mem, nums_, i, end));
    }
    return mem[start][end];
  }

  public int maxCoins(int[] nums) {
    int[] nums_ = new int[nums.length + 2];
    nums_[0] = 1;
    nums_[nums.length + 1] = 1;
    for (int i = 0; i < nums.length; i++) {
      nums_[i + 1] = nums[i];
    }

    int[][] mem = new int[nums.length + 2][nums.length + 2];
    for (int[] mem_ : mem) {
      Arrays.fill(mem_, -1);
    }

    return burst(mem, nums_, 0, nums.length + 1);
  }
}
