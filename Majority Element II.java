public class Solution {
  private void majorityElement(Map<Integer, Integer> num_count) {
    List<Integer> remove = new ArrayList<>();
    for (Integer i : num_count.keySet()) {
      int new_count = num_count.get(i) - 1;
      num_count.put(i, new_count);
      if (new_count == 0)
        remove.add(i);
    }
    for (Integer i : remove)
      num_count.remove(i);
  }

  private void majorityElement(Map<Integer, Integer> num_count, int add) {
    if (num_count.containsKey(add)) {
      int old_count = num_count.get(add);
      num_count.put(add, old_count + 1);
    } else {
      num_count.put(add, 1);
    }
  }

  public List<Integer> majorityElement(int[] nums) {
    List<Integer> ret = new ArrayList<>();
    Map<Integer, Integer> num_count = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (num_count.size() <= 2)
        majorityElement(num_count, nums[i]);
      if (num_count.size() == 3)
        majorityElement(num_count);
    }
    int n[] = num_count.keySet().stream().mapToInt(x -> x).toArray();
    int c[] = new int[n.length];
    Arrays.fill(c, 0);
    for (int i : nums) {
      for (int j = 0; j < n.length; j++) {
        if (i == n[j])
          c[j]++;
      }
    }
    for (int j = 0; j < n.length; j++) {
      if (c[j] > nums.length / 3)
        ret.add(n[j]);
    }
    return ret;
  }
}
