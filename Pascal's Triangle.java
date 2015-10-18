public class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ret = new ArrayList<>();
    if (numRows == 0)
      return ret;
    List<Integer> row1 = Stream.of(1).collect(Collectors.toList());
    ret.add(row1);
    if (numRows == 1)
      return ret;
    List<Integer> row2 = Stream.of(1, 1).collect(Collectors.toList());
    ret.add(row2);
    if (numRows == 0)
      return ret;
    for (int i = 3; i <= numRows; i++) {
      List<Integer> lastrow = ret.get(ret.size() - 1);
      List<Integer> newrow = new ArrayList<>();
      for (int j = 1; j < lastrow.size(); j++) {
        newrow.add(lastrow.get(j - 1) + lastrow.get(j));
      }
      newrow.add(0, 1);
      newrow.add(newrow.size(), 1);
      ret.add(newrow);
    }
    return ret;
  }
}
