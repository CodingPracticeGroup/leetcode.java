public class Solution {
  public List<Integer> grayCode(int n) {
    List<Integer> ret = new ArrayList<>();
    ret.add(0);
    for (int i = 0; i < n; i++) {
      List<Integer> mirror = new ArrayList<>(ret);
      Collections.reverse(mirror);
      for (int j = 0; j < mirror.size(); j++) {
        mirror.set(j, mirror.get(j) | (1 << i));
      }
      ret.addAll(mirror);
    }
    return ret;
  }
}
