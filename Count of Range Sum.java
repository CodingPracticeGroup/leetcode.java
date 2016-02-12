public class Solution {
  int[] bit = null;

  private void bitUpdate(int idx, int delta) {
    idx++;
    for (int i = idx; i < bit.length; i += Integer.lowestOneBit(i)) {
      bit[i] += delta;
    }
  }

  private int bitSum(int idx) {
    idx++;
    int sum = 0;
    for (int i = idx; i > 0; i -= Integer.lowestOneBit(i)) {
      sum += bit[i];
    }
    return sum;
  }

  public int countRangeSum(int[] nums, int lower, int upper) {
    if (nums.length == 0)
      return 0;
    long sums[] = new long[nums.length];
    sums[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      sums[i] = sums[i - 1] + nums[i];
    }
    long sorted[] = Arrays.stream(sums).distinct().sorted().toArray();
    bit = new int[sorted.length + 1];
    Arrays.fill(bit, 0);

    int ret = 0;
    for (int i = sums.length - 1; i >= 0; i--) {
      bitUpdate(Arrays.binarySearch(sorted, sums[i]), 1);

      // lower <= sums[j]-sums[i-1] = sum[i..j] (inclusive)
      int j1 = Arrays.binarySearch(sorted, lower + (i - 1 >= 0 ? sums[i - 1] : 0));
      if (j1 < 0) {
        j1 = -j1 - 1; // inclusive
      }
      // sums[j]-sums[i-1] <= upper
      int j2 = Arrays.binarySearch(sorted, upper + (i - 1 >= 0 ? sums[i - 1] : 0));
      if (j2 < 0) {
        j2 = (-j2 - 1) - 1; // inclusive
      }
      ret += bitSum(j2) - bitSum(j1 - 1);
    }
    return ret;
  }
}
