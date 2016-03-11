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
----
public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> ret = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      int low = i + 1;
      int high = nums.length - 1;
      while (low < high) {
        if (nums[i] + nums[low] + nums[high] < 0) {
          low++;
        } else if (nums[i] + nums[low] + nums[high] > 0) {
          high--;
        } else {
          List<Integer> l = new ArrayList<>();
          l.add(nums[i]);
          l.add(nums[low++]);
          l.add(nums[high--]);
          ret.add(l);
        }
      }
    }
    return new ArrayList<List<Integer>>(ret);
  }
}
--------------
public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> ret = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        if (nums[i] + nums[j] + nums[k] < 0) {
          j++;
        } else if (nums[i] + nums[j] + nums[k] > 0) {
          k--;
        } else {
          List<Integer> l = new ArrayList<>();
          l.add(nums[i]);
          l.add(nums[j]);
          l.add(nums[k]);
          ret.add(l);
          j++;
          k--;
        }
      }
    }
    return new ArrayList<List<Integer>>(ret);
  }
}
