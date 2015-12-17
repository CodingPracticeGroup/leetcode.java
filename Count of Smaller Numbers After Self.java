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
