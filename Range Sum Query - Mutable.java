import java.util.Arrays;

public class NumArray {
  int[] BIT = null;

  public NumArray(int[] nums) {
    BIT = new int[nums.length + 1]; // offset
    Arrays.fill(BIT, 0);
    int idx = 1; // offset
    for (int n : nums) {
      for (int j = idx++; j < BIT.length; j += lowbit(j)) {
        BIT[j] += n;
      }
    }
  }

  int lowbit(int x) { // [1, )
    return x & (x ^ (x - 1));
  }

  public void update(int i, int val) { // [0, )
    i++; // offset
    int orig = sum(i) - sum(i - 1);
    int delta = val - orig;
    for (int j = i; j < BIT.length; j += lowbit(j)) {
      BIT[j] += delta;
    }
  }

  int sum(int k) { // [1, )
    int ret = 0;
    for (int i = k; i > 0; i -= lowbit(i)) {
      ret += BIT[i];
    }
    return ret;
  }

  public int sumRange(int i, int j) {
    i++; // offset
    j++; // offset
    return sum(j) - sum(i - 1);
  }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
