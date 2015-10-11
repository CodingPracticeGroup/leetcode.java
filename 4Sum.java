import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Set<List<Integer>> ret = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int k = j + 1, m = nums.length - 1;
        while (k < m) {
          if (nums[i] + nums[j] + nums[k] + nums[m] < target) {
            k++;
          } else if (nums[i] + nums[j] + nums[k] + nums[m] > target) {
            m--;
          } else {
            List<Integer> l = new ArrayList<Integer>();
            l.add(nums[i]);
            l.add(nums[j]);
            l.add(nums[k]);
            l.add(nums[m]);
            ret.add(l);
            k++;
            m--;
          }
        }
      }
    }
    return new ArrayList<List<Integer>>(ret);
  }
}
