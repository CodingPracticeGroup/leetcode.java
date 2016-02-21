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
--------------------
public class NumArray {
  int[] bit = null; // (Binary Indexed Trees)

  public NumArray(int[] nums) {
    bit = new int[nums.length + 1]; // start from 1
    Arrays.fill(bit, 0);

    for (int i = 0; i < nums.length; i++) {
      update(i, nums[i]);
    }
  }

  void update(int i, int val) {
    int old = sumRange(i, i);
    int delta = val - old;

    i++; // start from 1

    for (int j = i; j < bit.length; j += Integer.lowestOneBit(j)) {
      bit[j] += delta;
    }
  }

  public int sumRange(int i, int j) { // inclusive
    i++; // start from 1
    j++; // start from 1

    int sumi1 = 0;
    for (int k = i - 1; k > 0; k -= Integer.lowestOneBit(k)) {
      sumi1 += bit[k];
    }

    int sumj = 0;
    for (int k = j; k > 0; k -= Integer.lowestOneBit(k)) {
      sumj += bit[k];
    }

    return sumj - sumi1;
  }
}
----------------
public class NumArray {

  int bit[] = null;
  int n[] = null;

  public NumArray(int[] nums) {
    bit = new int[nums.length + 1];
    n = new int[nums.length]; // default 0
    for (int i = 0; i < nums.length; i++) {
      update(i, nums[i]);
    }
  }

  void update(int i, int val) {
    int delta = val - n[i];
    n[i] = val;

    i++;
    for (int j = i; j < bit.length; j += Integer.lowestOneBit(j)) {
      bit[j] += delta;
    }
  }

  private int sum(int i) {
    i++;

    int ret = 0;
    for (int j = i; j > 0; j -= Integer.lowestOneBit(j)) {
      ret += bit[j];
    }
    return ret;
  }

  public int sumRange(int i, int j) {
    return sum(j) - sum(i - 1);
  }
}
