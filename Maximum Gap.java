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
-------------------
public class Solution {
  public int maximumGap(int[] nums) {
    int count = nums.length;
    if (count < 2)
      return 0;

    int max = Arrays.stream(nums).max().getAsInt();
    int min = Arrays.stream(nums).min().getAsInt();
    if (max == min) {
      return 0;
    }

    int bucket_size = Math.max(1, (max - min) / (count - 1)); // can be smaller, so that more empty bucket, but at least 1
    int bucket_num = (max - min) / bucket_size + 1; // the max id, so that should +1 for len

    int bucket_max[] = new int[bucket_num];
    Arrays.fill(bucket_max, -1);
    int bucket_min[] = new int[bucket_num];
    Arrays.fill(bucket_min, -1);

    for (int i : nums) {
      int id = (i - min) / bucket_size;
      if (bucket_max[id] == -1) {
        bucket_max[id] = i;
      }
      bucket_max[id] = Math.max(bucket_max[id], i);
      if (bucket_min[id] == -1) {
        bucket_min[id] = i;
      }
      bucket_min[id] = Math.min(bucket_min[id], i);
    }

    int ret = 0;
    int last_max = -1;
    for (int i = 0; i < bucket_num; i++) {
      if (bucket_min[i] != -1 && last_max != -1) { // at least 1 empty bucket
        ret = Math.max(ret, bucket_min[i] - last_max);
      }
      if (bucket_max[i] != -1) {
        last_max = bucket_max[i];
      }
    }
    return ret;
  }
}
