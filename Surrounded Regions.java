public class Solution {
  private void solve_dfs(char[][] board, int i, int j, int r, int c) {
    // recursion stack overflow
    Deque<Integer> istack = new ArrayDeque<>();
    Deque<Integer> jstack = new ArrayDeque<>();

    istack.push(i);
    jstack.push(j);
    while (!istack.isEmpty()) {
      i = istack.pop();
      j = jstack.pop();
      board[i][j] = '$';
      if (i - 1 >= 0 && board[i - 1][j] == 'O') {
        istack.push(i - 1);
        jstack.push(j);
      }
      if (j - 1 >= 0 && board[i][j - 1] == 'O') {
        istack.push(i);
        jstack.push(j - 1);
      }
      if (i + 1 < r && board[i + 1][j] == 'O') {
        istack.push(i + 1);
        jstack.push(j);
      }
      if (j + 1 < c && board[i][j + 1] == 'O') {
        istack.push(i);
        jstack.push(j + 1);
      }
    }
  }

  public void solve(char[][] board) {
    int r = board.length;
    if (r == 0)
      return;
    int c = board[0].length;
    if (c == 0)
      return;
    for (int i = 0; i < r; i++) {
      if (board[i][0] == 'O') {
        solve_dfs(board, i, 0, r, c);
      }
      if (board[i][c - 1] == 'O') {
        solve_dfs(board, i, c - 1, r, c);
      }
    }
    for (int i = 0; i < c; i++) {
      if (board[0][i] == 'O') {
        solve_dfs(board, 0, i, r, c);
      }
      if (board[r - 1][i] == 'O') {
        solve_dfs(board, r - 1, i, r, c);
      }
    }
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (board[i][j] == '$') {
          board[i][j] = 'O';
        } else {
          board[i][j] = 'X';
        }
      }
    }
  }
}
