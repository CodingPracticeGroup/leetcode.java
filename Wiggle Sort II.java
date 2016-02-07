public class Solution {
  public void wiggleSort(int[] nums) {
    int dup[] = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      dup[i] = nums[i];
    }
    Arrays.sort(dup);

    int idx = nums.length - 1;
    for (int i = 1; i < nums.length; i += 2) {
      nums[i] = dup[idx--];
    }
    for (int i = 0; i < nums.length; i += 2) {
      nums[i] = dup[idx--];
    }
  }
}
--------------
public class Solution {
  public void wiggleSort(int[] nums) {
    int c[] = nums.clone();
    Arrays.sort(c);

    int idx = c.length - 1; // 从后往前的原因其实是，单双数长度的区别：https://leetcode.com/discuss/76965/3-lines-python-with-explanation-proof
    for (int i = 1; i < nums.length; i += 2) {
      nums[i] = c[idx--];
    }
    for (int i = 0; i < nums.length; i += 2) {
      nums[i] = c[idx--];
    }
  }
}
