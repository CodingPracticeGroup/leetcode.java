import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
  int lowbit(int x) { // x > 0
    return x & (x ^ (x - 1));
  }

  int sum(int BIT[], int k) {
    int ans = 0;
    for (int i = k - 1; i > 0; i -= lowbit(i)) { // [1, k)
      ans += BIT[i];
    }
    return ans;
  }

  void edit(int BIT[], int i, int delta) {
    for (int j = i; j < BIT.length; j += lowbit(j)) {
      BIT[j] += delta;
    }
  }

  public List<Integer> countSmaller(int[] nums) {
    List<Integer> sortedDistinct =
        Arrays.stream(nums).sorted().distinct().boxed().collect(Collectors.toList());
    Map<Integer, Integer> numIdx = new HashMap<>();
    int idx = 1;
    for (Integer i : sortedDistinct) {
      numIdx.put(i, idx++);
    }

    int[] BIT = new int[sortedDistinct.size() + 1];
    LinkedList<Integer> ret = new LinkedList<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      idx = numIdx.get(nums[i]);
      ret.offerFirst(sum(BIT, idx)); // count
      edit(BIT, idx, 1); // accumulate
    }
    return ret;
  }
}
--------------
public class Solution {
  public List<Integer> countSmaller(int[] nums) {
    LinkedList<Integer> ret = new LinkedList<>();
    if (nums.length == 0) {
      return ret;
    }
    ret.offerFirst(0);
    for (int i = nums.length - 2; i >= 0; i--) {
      // Arrays.sort(nums, i + 1, nums.length); // cannot pass large test
      int idx = Arrays.binarySearch(nums, i + 1, nums.length, nums[i]);
      if (idx >= 0) {
        while (idx - 1 > i && nums[idx] == nums[idx - 1]) {
          idx--;
        }
      } else {
        idx = -idx - 1;
      }
      ret.offerFirst(idx - i - 1);

      idx--;
      int tmp = nums[i];
      for (int j = i; j < idx; j++) {
        nums[j] = nums[j + 1];
      }
      nums[idx] = tmp;
    }
    return ret;
  }
}
-----------------------
public class Solution {
  private void add(int[] b, int idx, int delta) {
    idx++;
    for (int i = idx; i < b.length; i += Integer.lowestOneBit(i)) {
      b[i] += delta;
    }
  }

  private int sum(int[] b, int idx) {
    idx++;
    int ret = 0;
    for (int i = idx; i > 0; i -= Integer.lowestOneBit(i)) {
      ret += b[i];
    }
    return ret;
  }

  public List<Integer> countSmaller(int[] nums) {
    int[] d = Arrays.stream(nums).distinct().sorted().toArray(); // logic idx
    int[] b = new int[d.length + 1];
    LinkedList<Integer> ret = new LinkedList<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      int j = Arrays.binarySearch(d, nums[i]); // always found
      ret.offerFirst(j - 1 >= 0 ? sum(b, j - 1) : 0);
      //
      add(b, j, 1);
    }
    return ret;
  }
}
