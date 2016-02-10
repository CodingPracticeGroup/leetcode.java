public class Solution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    int max = 0;
    while (!set.isEmpty()) {
      int cur = set.iterator().next();
      set.remove(cur);

      int left = cur - 1;
      while (set.contains(left)) {
        set.remove(left);
        left--;
      }
      int right = cur + 1;
      while (set.contains(right)) {
        set.remove(right);
        right++;
      }

      max = Math.max(max, right - left - 1);
    }
    return max;
  }
}
--------------
public class Solution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> s = new HashSet<>();
    for (int i : nums) {
      s.add(i);
    }
    int ret = 0;
    for (int i : nums) {
      if (s.contains(i)) { // hit
        s.remove(i); // remove
        int low = i - 1;
        while (s.contains(low)) { // hit
          s.remove(low); // remove
          low--;
        }
        int high = i + 1;
        while (s.contains(high)) { // hit
          s.remove(high); // remove
          high++;
        }
        ret = Math.max(ret, high - low - 1);
      }
    }
    return ret;
  }
}
