import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
  private void grayCode_set_bit(int[] board, int idx, int bit) {
    board[idx] = board[idx] | 1 << bit;
  }

  public List<Integer> grayCode(int n) {
    int[] board = new int[(int) Math.pow(2, n)];
    Arrays.fill(board, 0);
    for (int bitidx = 0; bitidx < n; bitidx++) {
      int len = (int) Math.pow(2, bitidx);
      for (int i = 0; i < len; i++) {
        board[len * 2 - 1 - i] = board[i];
        grayCode_set_bit(board, len * 2 - 1 - i, bitidx);
      }
    }
    return Arrays.stream(board).boxed().collect(Collectors.toList());
  }
}
