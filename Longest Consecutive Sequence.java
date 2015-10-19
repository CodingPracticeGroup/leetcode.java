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
