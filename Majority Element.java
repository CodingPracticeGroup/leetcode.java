public class Solution {
  public int majorityElement(int[] nums) {
    Map<Integer, Long> map =
        Arrays.stream(nums).boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    int ret = nums[0];
    long maxcount = 1;
    for (Integer i : map.keySet()) {
      if (map.get(i) > maxcount) {
        maxcount = map.get(i);
        ret = i;
      }
    }
    return ret;
  }
}
