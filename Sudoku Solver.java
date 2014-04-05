public class Solution {
	public void solveSudoku(char[][] board) {
		recursion(board);
	}

	private boolean recursion(char[][] board) {
		if (done(board)) { // found
			return true; // report
		} else {
			int i = 0;
			int j = 0;
			boolean notFound = true;
			for (i = 0; notFound && i < 9; i++) {
				for (j = 0; notFound && j < 9; j++) {
					if (board[i][j] == '.') {
						notFound = false;
						break;
					}
				}
				if (!notFound) {
					break;
				}
			}
			// candidates
			for (char k = '1'; k <= '9'; k++) {
				char track = board[i][j];
				// forward
				board[i][j] = k;
				// prune
				if (valid(board, i, j)) {
					// explore
					boolean found = recursion(board);
					if (found) {
						return true;
					}
				}
				// backward
				board[i][j] = track;
			}
			return false;
		}
	}

	private boolean done(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					return false;
				}
			}
		}
		return true;
	}

	private boolean valid(char[][] board, int i, int j) {
		int check[] = new int[9];
		for (int x = 0; x < 9; x++) {
			if (board[i][x] != '.' && check[board[i][x] - '1'] == 1) {
				return false;
			} else {
				if (board[i][x] != '.') {
					check[board[i][x] - '1'] = 1;
				}
			}
		}
		check = new int[9];
		for (int x = 0; x < 9; x++) {
			if (board[x][j] != '.' && check[board[x][j] - '1'] == 1) {
				return false;
			} else {
				if (board[x][j] != '.') {
					check[board[x][j] - '1'] = 1;
				}
			}
		}
		int i3 = (i / 3) * 3 + 1;
		int j3 = (j / 3) * 3 + 1;
		check = new int[9];
		if (board[i3 - 1][j3 - 1] != '.' && check[board[i3 - 1][j3 - 1] - '1'] == 1) {
			return false;
		} else {
			if (board[i3 - 1][j3 - 1] != '.') {
				check[board[i3 - 1][j3 - 1] - '1'] = 1;
			}
		}
		if (board[i3 - 1][j3] != '.' && check[board[i3 - 1][j3] - '1'] == 1) {
			return false;
		} else {
			if (board[i3 - 1][j3] != '.') {
				check[board[i3 - 1][j3] - '1'] = 1;
			}
		}
		if (board[i3 - 1][j3 + 1] != '.' && check[board[i3 - 1][j3 + 1] - '1'] == 1) {
			return false;
		} else {
			if (board[i3 - 1][j3 + 1] != '.') {
				check[board[i3 - 1][j3 + 1] - '1'] = 1;
			}
		}
		if (board[i3][j3 - 1] != '.' && check[board[i3][j3 - 1] - '1'] == 1) {
			return false;
		} else {
			if (board[i3][j3 - 1] != '.') {
				check[board[i3][j3 - 1] - '1'] = 1;
			}
		}
		if (board[i3][j3] != '.' && check[board[i3][j3] - '1'] == 1) {
			return false;
		} else {
			if (board[i3][j3] != '.') {
				check[board[i3][j3] - '1'] = 1;
			}
		}
		if (board[i3][j3 + 1] != '.' && check[board[i3][j3 + 1] - '1'] == 1) {
			return false;
		} else {
			if (board[i3][j3 + 1] != '.') {
				check[board[i3][j3 + 1] - '1'] = 1;
			}
		}
		if (board[i3 + 1][j3 - 1] != '.' && check[board[i3 + 1][j3 - 1] - '1'] == 1) {
			return false;
		} else {
			if (board[i3 + 1][j3 - 1] != '.') {
				check[board[i3 + 1][j3 - 1] - '1'] = 1;
			}
		}
		if (board[i3 + 1][j3] != '.' && check[board[i3 + 1][j3] - '1'] == 1) {
			return false;
		} else {
			if (board[i3 + 1][j3] != '.') {
				check[board[i3 + 1][j3] - '1'] = 1;
			}
		}
		if (board[i3 + 1][j3 + 1] != '.' && check[board[i3 + 1][j3 + 1] - '1'] == 1) {
			return false;
		} else {
			if (board[i3 + 1][j3 + 1] != '.') {
				check[board[i3 + 1][j3 + 1] - '1'] = 1;
			}
		}
		return true;
	}
}
