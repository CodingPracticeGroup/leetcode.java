public class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ret = new ArrayList<>();
    if (numRows == 0) {
      return ret;
    }

    List<Integer> lastRow = new ArrayList<>();
    lastRow.add(1);
    ret.add(lastRow);
    if (numRows == 1) {
      return ret;
    }

    lastRow = new ArrayList<>();
    lastRow.add(1);
    lastRow.add(1);
    ret.add(lastRow);

    for (int i = 3; i <= numRows; i++) {
      List<Integer> newRow = new ArrayList<>();
      newRow.add(1);
      for (int j = 1; j < i - 1; j++) {
        newRow.add(lastRow.get(j - 1) + lastRow.get(j));
      }
      newRow.add(1);
      ret.add(newRow);
      lastRow = newRow;
    }
    return ret;
  }
}
