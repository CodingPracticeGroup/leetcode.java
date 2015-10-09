import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.function.Function;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    int ret[] = new int[] {-1, -1};

    Map<Integer, Integer> val_idx =
        IntStream.range(0, nums.length).boxed()
            .collect(Collectors.toConcurrentMap(i -> nums[i], Function.identity(), (v1, v2) -> {
              if (v1 >= 0 && v2 >= 0 && nums[v1] + nums[v2] == target) {
                ret[0] = v1 + 1;
                ret[1] = v2 + 1;
              }
              return -1;
            }));

    if (ret[1] >= 0) {
      Arrays.sort(ret);
      return ret;
    }

    return IntStream.range(0, nums.length)
        .filter(i -> nums[i] * 2 != target && val_idx.containsKey(target - nums[i]))
        .map(i -> i + 1).sorted().toArray();
  }
}
