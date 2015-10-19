public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    List<Integer> last = null;
    for (List<Integer> row : triangle) {
      int size = row.size();
      if (size >= 2) {
        row.set(0, row.get(0) + last.get(0));
        row.set(size - 1, row.get(size - 1) + last.get(size - 2));
        for (int i = 1; i <= size - 2; i++) {
          row.set(i, row.get(i) + Math.min(last.get(i - 1), last.get(i)));
        }
      }
      last = row;
    }
    int min = last.get(0);
    for (Integer i : last) {
      min = Math.min(min, i);
    }
    return min;
  }
}
