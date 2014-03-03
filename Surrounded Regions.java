import java.util.ArrayDeque;

public class Solution {
	public static final char C = '+';

	public void solve(char[][] board) {
		int rowMax = board.length;
		if (rowMax <= 0)
			return;
		int colMax = board[0].length;
		if (colMax <= 0)
			return;
		// Note: The Solution object is instantiated only once and is reused by each test case.
		for (int i = 0; i < colMax; i++) { // initialize the most outside row
			if (board[0][i] == 'O') {
				dfsStack(board, 0, i);
			}
			if (board[rowMax - 1][i] == 'O') {
				bfsQueue(board, rowMax - 1, i);
			}
		}
		for (int i = 0; i < rowMax; i++) { // initialize the most outside col
			if (board[i][0] == 'O') {
				bfsQueue(board, i, 0);
			}
			if (board[i][colMax - 1] == 'O') {
				dfsStack(board, i, colMax - 1);
			}
		}
		// recover mark
		for (int i = 0; i < rowMax; i++) {
			for (int j = 0; j < colMax; j++) {
				if (board[i][j] == C) {
					board[i][j] = 'O';
				} else {
					board[i][j] = 'X';
				}
			}
		}
	}

	/**
	 * bfs uses queue, while dfs uses stack.
	 */
	private void bfsQueue(char[][] board, int row, int col) {
		int rowMax = board.length;
		int colMax = board[0].length;
		ArrayDeque<Integer> qRow = new ArrayDeque<Integer>(rowMax);
		ArrayDeque<Integer> qCol = new ArrayDeque<Integer>(colMax);

		// mark and enqueue
		board[row][col] = C;
		qRow.offer(row);
		qCol.offer(col);
		// while queue is not empty
		while (!qRow.isEmpty() && !qCol.isEmpty()) {
			// dequeue
			int r = qRow.poll();
			int c = qCol.poll();
			// we don't have process here

			// check neighbors, mark and enqueue
			if (r - 1 >= 0 && board[r - 1][c] == 'O') { // board[r-1][c]
				board[r - 1][c] = C;
				qRow.offer(r - 1);
				qCol.offer(c);
			}
			if (r + 1 < rowMax && board[r + 1][c] == 'O') { // board[r+1][c]
				board[r + 1][c] = C;
				qRow.offer(r + 1);
				qCol.offer(c);
			}
			if (c - 1 >= 0 && board[r][c - 1] == 'O') { // board[r][c-1]
				board[r][c - 1] = C;
				qRow.offer(r);
				qCol.offer(c - 1);
			}
			if (c + 1 < colMax && board[r][c + 1] == 'O') { // board[r][c+1]
				board[r][c + 1] = C;
				qRow.offer(r);
				qCol.offer(c + 1);
			}
		}
	}

	/**
	 * graph marks vertices in queue/stack, while tree does not because there is no cycle on tree.
	 */
	private void dfsStack(char[][] board, int row, int col) {
		int rowMax = board.length;
		int colMax = board[0].length;
		ArrayDeque<Integer> qRow = new ArrayDeque<Integer>(rowMax);
		ArrayDeque<Integer> qCol = new ArrayDeque<Integer>(colMax);

		// mark and push
		board[row][col] = C;
		qRow.push(row);
		qCol.push(col);
		// while stack is not empty
		while (!qRow.isEmpty() && !qCol.isEmpty()) {
			// pop
			int r = qRow.pop();
			int c = qCol.pop();
			// we don't have process here

			// check neighbors, mark and push
			if (r - 1 >= 0 && board[r - 1][c] == 'O') { // board[r-1][c]
				board[r - 1][c] = C;
				qRow.push(r - 1);
				qCol.push(c);
			}
			if (r + 1 < rowMax && board[r + 1][c] == 'O') { // board[r+1][c]
				board[r + 1][c] = C;
				qRow.push(r + 1);
				qCol.push(c);
			}
			if (c - 1 >= 0 && board[r][c - 1] == 'O') { // board[r][c-1]
				board[r][c - 1] = C;
				qRow.push(r);
				qCol.push(c - 1);
			}
			if (c + 1 < colMax && board[r][c + 1] == 'O') { // board[r][c+1]
				board[r][c + 1] = C;
				qRow.push(r);
				qCol.push(c + 1);
			}
		}
	}

}
