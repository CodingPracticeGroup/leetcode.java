public class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> s = new HashSet<>();
    for (int i : nums) {
      boolean b = s.add(i);
      if (b == false) {
        return true;
      }
    }
    return false;
  }
}
