public class Solution {
  public int maximumGap(int[] nums) {
    int ret = 0;
    if (nums.length < 2)
      return ret;
    Map<Integer, Long> nums_count =
        Arrays.stream(nums).boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    if (nums_count.size() <= 1)
      return ret;
    int max = nums_count.keySet().stream().max(Integer::compare).get();
    int min = nums_count.keySet().stream().min(Integer::compare).get();
    int bucket_size = (max - min + 1) / (nums_count.size() + 1); // at least one empty bucket
    Map<Integer, List<Integer>> map =
        nums_count.keySet().stream().collect(Collectors.groupingBy(x -> (x - min) / bucket_size));
    int last_idx = 0; // must not be empty because of min
    int max_idx = (max - min) / bucket_size; // must not be empty because of max
    for (int i = 0; i <= max_idx; i++) {
      if (!map.containsKey(i)) {
        while (i <= max_idx && !map.containsKey(i)) {
          i++;
        }
        int last_max = map.get(last_idx).stream().max(Integer::compare).get();
        int this_min = map.get(i).stream().min(Integer::compare).get();
        ret = Math.max(ret, this_min - last_max);
      }
      last_idx = i;
    }
    return ret;
  }
}