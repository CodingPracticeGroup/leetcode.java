public class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> ret = new ArrayList<>();
    ret.add(1);
    if (rowIndex == 0) {
      return ret;
    }
    ret.add(1);
    if (rowIndex == 1) {
      return ret;
    }
    for (int i = 2; i <= rowIndex; i++) {
      int last = 1;
      for (int j = 1; j < i; j++) {
        int cur = ret.get(j);
        ret.set(j, last + cur);
        last = cur;
      }
      ret.add(1);
    }
    return ret;
  }
}
