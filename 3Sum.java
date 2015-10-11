public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<Integer> exist = // Arrays.stream(nums).boxed().collect(Collectors.toSet());
        new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      exist.add(nums[i]);
    }
    Set<List<Integer>> ret = new HashSet<>();
    int i = 0;
    while (i < nums.length) {
      int j = i + 1;
      while (j < nums.length) {
        int target = 0 - nums[i] - nums[j];
        if ((nums[j] == target && j + 1 < nums.length && nums[j + 1] == target)
            || (nums[j] < target && exist.contains(target))) {
          List<Integer> l = new ArrayList<>();
          l.add(nums[i]);
          l.add(nums[j]);
          l.add(target);
          ret.add(l);
        }

        j++;
        while (j < nums.length && nums[j - 1] == nums[j]) {
          j++;
        }
      }

      i++;
      while (i < nums.length && nums[i - 1] == nums[i]) {
        i++;
      }
    }
    return new ArrayList<List<Integer>>(ret);
  }
}