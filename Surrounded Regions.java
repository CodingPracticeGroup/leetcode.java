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
---------------
public class Solution {
  int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

  private void mark1(char[][] board, int i, int j) {
    Deque<int[]> queue = new ArrayDeque<>();
    board[i][j] = '$';
    queue.offer(new int[] {i, j});
    while (!queue.isEmpty()) {
      int[] node = queue.poll();
      for (int[] dir : dirs) {
        int x = node[0] + dir[0];
        int y = node[1] + dir[1];
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
          board[x][y] = '$';
          queue.offer(new int[] {x, y});
        }
      }
    }
  }

  public void solve(char[][] board) {
    int m = board.length;
    if (m == 0)
      return;
    int n = board[0].length;
    if (n == 0)
      return;

    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O') {
        mark1(board, i, 0);
      }
      if (board[i][n - 1] == 'O') {
        mark1(board, i, n - 1);
      }
    }
    for (int j = 0; j < n; j++) {
      if (board[0][j] == 'O') {
        mark1(board, 0, j);
      }
      if (board[m - 1][j] == 'O') {
        mark1(board, m - 1, j);
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '$') {
          board[i][j] = 'O';
        } else {
          board[i][j] = 'X';
        }
      }
    }
  }
}
------------------
public class Solution {
  int dirs[][] = new int[][] {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

  void mark(char[][] board, int i, int j) {
    Deque<int[]> q = new ArrayDeque<>();
    q.offer(new int[] {i, j});
    board[i][j] = '$';
    while (!q.isEmpty()) {
      int[] p = q.poll();
      for (int[] dir : dirs) {
        int x = p[0] + dir[0];
        int y = p[1] + dir[1];
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
          q.offer(new int[] {x, y});
          board[x][y] = '$';
        }
      }
    }
  }

  public void solve(char[][] board) {
    if (board.length == 0 || board[0].length == 0)
      return;

    for (int i = 0; i < board.length; i++) {
      if (board[i][0] == 'O') {
        mark(board, i, 0);
      }
      if (board[i][board[0].length - 1] == 'O') {
        mark(board, i, board[0].length - 1);
      }
    }
    for (int j = 0; j < board[0].length; j++) {
      if (board[0][j] == 'O') {
        mark(board, 0, j);
      }
      if (board[board.length - 1][j] == 'O') {
        mark(board, board.length - 1, j);
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == '$') {
          board[i][j] = 'O';
        }
      }
    }
  }
}
