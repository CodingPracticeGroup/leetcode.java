public class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> row = new ArrayList<>();
    row.add(1);
    if (rowIndex == 0)
      return row;
    row.add(1);
    if (rowIndex == 1)
      return row;
    List<Integer> nextrow = new ArrayList<>();
    for (int i = 2; i <= rowIndex; i++) {
      nextrow.clear();
      for (int j = 1; j < row.size(); j++) {
        nextrow.add(row.get(j - 1) + row.get(j));
      }
      nextrow.add(0, 1);
      nextrow.add(nextrow.size(), 1);
      row.clear();
      row.addAll(nextrow);
    }
    return row;
  }
}
