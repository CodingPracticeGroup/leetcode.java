public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> ret = new HashSet<>();
    ret.add(new ArrayList<Integer>());
    for (int i = 0; i < nums.length; i++) {
      Set<List<Integer>> round = new HashSet<>();
      for (List<Integer> l : ret) {
        List<Integer> duplicate = new ArrayList<>(l);
        duplicate.add(nums[i]);
        round.add(duplicate);
      }
      ret.addAll(round);
    }
    return new ArrayList<List<Integer>>(ret);
  }
}
----------
public class Solution {
  private Set<List<Integer>> s(int[] nums, int start) {
    Set<List<Integer>> ret = new HashSet<>();
    ret.add(new ArrayList<Integer>());
    if (start >= nums.length) {
      return ret;
    }
    for (int i = start; i < nums.length; i++) { // pick nums[i]
      Set<List<Integer>> r = s(nums, i + 1);
      for (List<Integer> l : r) {
        l.add(0, nums[i]);
      }
      ret.addAll(r);
    }
    return ret;
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    return new ArrayList<List<Integer>>(s(nums, 0));
  }
}
---------------------
public class Solution {
  List<List<Integer>> s(int[] nums, int startPos) {
    List<List<Integer>> ret = new ArrayList<>(); // return

    if (startPos == nums.length) { // termination
      List<Integer> l = new ArrayList<>(); // termination item
      ret.add(l);
      return ret;
    }

    int nextPos = startPos + 1; // determine node range, cut head only
    while (nextPos < nums.length && nums[startPos] == nums[nextPos]) {
      nextPos++;
    }
    List<List<Integer>> r = s(nums, nextPos); // dfs

    for (List<Integer> l : r) { // iterate dfs result/fetch clidren result
      for (int count = 0; count <= nextPos - startPos; count++) { // process current node/construct new result
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
          l2.add(nums[startPos]);
        }
        l2.addAll(l);
        ret.add(l2);
      }
    }

    return ret;
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    // 系统化搜索不应该产生duplicates，所以不应该用set
    return s(nums, 0);
  }
}
