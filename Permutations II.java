public class Solution {
  private void permuteUnique_bt(int[] nums, Set<Integer> idx, Set<List<Integer>> ret,
      Deque<Integer> stack) {
    if (idx.isEmpty()) {
      ret.add(new ArrayList<Integer>(stack));
    } else {
      Set<Integer> tabu = new HashSet<>();
      for (Integer i : idx) {
        if (!tabu.contains(nums[i])) {
          stack.push(nums[i]);
          Set<Integer> forchild = new HashSet<>(idx);
          forchild.remove(i);
          permuteUnique_bt(nums, forchild, ret, stack);
          stack.pop();
          tabu.add(nums[i]);
        }
      }
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    Set<List<Integer>> ret = new HashSet<>();
    Set<Integer> idx = new HashSet<>();
    // IntStream.range(0, nums.length).boxed().collect(Collectors.toSet());
    for (int i = 0; i < nums.length; i++) {
      idx.add(i);
    }

    permuteUnique_bt(nums, idx, ret, new ArrayDeque<Integer>());
    return new ArrayList<List<Integer>>(ret);
  }
}
-------------
public class Solution {
  private Set<List<Integer>> p(Map<Integer, Long> m) {
    Set<List<Integer>> ret = new HashSet<>();
    if (m.isEmpty()) {
      ret.add(new ArrayList<>());
      return ret;
    }
    for (Integer i : m.keySet()) {
      Map<Integer, Long> mm = new HashMap<>(m);
      if (mm.get(i) == 1) {
        mm.remove(i);
      } else {
        mm.put(i, mm.get(i) - 1);
      }
      Set<List<Integer>> r = p(mm);
      for (List<Integer> l : r) {
        l.add(i);
        ret.add(l);
      }
    }
    return ret;
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    Map<Integer, Long> m = Arrays.stream(nums).boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    return new ArrayList<List<Integer>>(p(m));
  }
}
--------------------------------
public class Solution {
  void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  Set<List<Integer>> p(int[] nums, int startPos) {
    Set<List<Integer>> ret = new HashSet<>(); // return

    if (startPos == nums.length) { // termination
      List<Integer> l = new ArrayList<>(); // item
      ret.add(l);
      return ret;
    }

    Set<Integer> tabu = new HashSet<>();
    for (int i = startPos; i < nums.length; i++) { // branch
      swap(nums, startPos, i); // freeze [0-startPos], the rest are candidates
      if (!tabu.contains(nums[startPos])) { // prune
        tabu.add(nums[startPos]);
        Set<List<Integer>> r = p(nums, startPos + 1); // dfs recursion children
        for (List<Integer> l : r) { // iterate children
          l.add(0, nums[startPos]); // construct
          ret.add(l); // add to current node
        }
      }
      swap(nums, startPos, i); // restore for next branch
    }

    return ret; // default termination
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    return new ArrayList<List<Integer>>(p(nums, 0));
  }
}
