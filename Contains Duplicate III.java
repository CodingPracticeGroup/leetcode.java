public class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeMap<Long, Integer> window = new TreeMap<>(); // n * log k
    for (int i = 0; i < nums.length; i++) {
      if (i - k - 1 >= 0) {
        window.put((long) nums[i - k - 1], window.get((long) nums[i - k - 1]) - 1);
        if (window.get((long) nums[i - k - 1]) == 0) {
          window.remove((long) nums[i - k - 1]);
        }
      }
      //
      Long floor = window.floorKey((long) nums[i]);
      if (floor != null && nums[i] - floor <= t) {
        return true;
      }
      Long ceiling = window.ceilingKey((long) nums[i]);
      if (ceiling != null && ceiling - nums[i] <= t) {
        return true;
      }
      //
      if (!window.containsKey((long) nums[i])) {
        window.put((long) nums[i], 0);
      }
      window.put((long) nums[i], window.get((long) nums[i]) + 1);
    }
    return false;
  }
}
-------------
public class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums.length < 2 || k < 1) {
      return false;
    }

    TreeMap<Integer, Integer> vc = new TreeMap<>();
    vc.put(nums[0], 1);
    for (int i = 1; i < nums.length; i++) {
      if (i - k - 1 >= 0) {
        vc.put(nums[i - k - 1], vc.get(nums[i - k - 1]) - 1);
        if (vc.get(nums[i - k - 1]) == 0) {
          vc.remove(nums[i - k - 1]);
        }
      }

      Integer floor = vc.floorKey(nums[i]);
      if (floor == null) {
        floor = vc.firstKey();
      }
      Integer ceiling = vc.ceilingKey(nums[i]);
      if (ceiling == null) {
        ceiling = vc.lastKey();
      }
      if (Math.abs((long) nums[i] - floor) <= t || Math.abs((long) nums[i] - ceiling) <= t) {
        return true;
      }

      if (!vc.containsKey(nums[i])) {
        vc.put(nums[i], 0);
      }
      vc.put(nums[i], vc.get(nums[i]) + 1);
    }
    return false;
  }
}
----------------
public class Solution {
  private long id(int i, int t) {
    long d = (long) i - Integer.MIN_VALUE;
    return d / (t + 1);
  }

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums.length < 2 || k < 1 || t < 0) {
      return false;
    }
    Map<Long, Integer> m = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (i - k - 1 >= 0) {
        long id = id(nums[i - k - 1], t);
        m.remove(id);
      }

      long id = id(nums[i], t);
      if (m.containsKey(id)
          || (m.containsKey(id + 1) && Math.abs((long) nums[i] - m.get(id + 1)) <= t)
          || (m.containsKey(id - 1) && Math.abs((long) nums[i] - m.get(id - 1)) <= t)) {
        return true;
      }

      m.put(id, nums[i]);
    }
    return false;
  }
}
