public class Solution {
  public List<Integer> majorityElement(int[] nums) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int i : nums) {
      if (!count.containsKey(i))
        count.put(i, 0);
      count.put(i, count.get(i) + 1);
      if (count.size() >= 3) {
        for (Integer j : count.keySet()) {
          count.put(j, count.get(j) - 1);
        }
        Set<Integer> tabu =
            count.keySet().stream().filter(x -> count.get(x).equals(0)).collect(Collectors.toSet());
        for (Integer j : tabu) {
          count.remove(j);
        }
      }
    }
    for (Integer i : count.keySet()) {
      count.put(i, 0);
    }
    for (int i : nums) {
      if (count.containsKey(i)) {
        count.put(i, count.get(i) + 1);
      }
    }
    return count.keySet().stream().filter(x -> count.get(x) > nums.length / 3)
        .collect(Collectors.toList());
  }
}
